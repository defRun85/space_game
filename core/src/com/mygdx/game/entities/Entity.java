package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.components.*;
import com.mygdx.game.input.PlayerInput;

import java.util.ArrayList;

import static com.mygdx.game.components.Component.TOKEN;

public class Entity {

    protected EntityConfig config;

    protected ArrayList<Component> components;
    protected PhysicsComponent physicsComponent;
    protected GraphicsComponent graphicsComponent;
    protected ProjectileComponent projectileComponent;

    protected PlayerInput playerInput;

    public enum State {
        MOVE_LEFT,
        MOVE_RIGHT,
        MOVE_UP,
        MOVE_DOWN,
        IDLE
    }

    public Entity(PhysicsComponent _physicsComponent, GraphicsComponent _graphicsComponent, ProjectileComponent _projectileComponent) {

        this.components = new ArrayList<Component>();

        physicsComponent = _physicsComponent;
        graphicsComponent = _graphicsComponent;
        projectileComponent = _projectileComponent;

        components.add(physicsComponent);
        components.add(graphicsComponent);
        components.add(projectileComponent);

    }

    public Entity(PhysicsComponent _physicsComponent, GraphicsComponent _graphicsComponent) {

        this.components = new ArrayList<Component>();

        physicsComponent = _physicsComponent;
        graphicsComponent = _graphicsComponent;

        components.add(physicsComponent);
        components.add(graphicsComponent);

    }

    public void init() {
        setPosition(this.config.getStartPosition());
        this.physicsComponent.setCollisionBox(this);
    }

    public void initInput(Entity entity) {
        playerInput = new PlayerInput(entity);
        Gdx.input.setInputProcessor(playerInput);
    }

    public void update(float delta) {
        physicsComponent.update(this, delta);
    }

    public void update(float delta, Array<Entity> entities) {
        physicsComponent.update(this, delta, entities);
        projectileComponent.update(delta, entities);
    }

    public void render(SpriteBatch batch) {
        this.graphicsComponent.render(batch, this);

        if ( projectileComponent != null ) {
            projectileComponent.render(batch);
        }

    }

    public void sendMessage(Component.MESSAGE type, String message) {

        String messageString = type + TOKEN + message;

        for ( Component component : components ) {
            component.receiveMessage(messageString);
        }

    }

    public Vector2 getPosition() {
        return physicsComponent.getPosition();
    }

    public void setPosition(Vector2 _position) { this.physicsComponent.setPosition(_position); }

    public float getCollisionBoxSize() {
        return this.config.getCollisionBoxSize();
    }

    public Rectangle getCollisonBox() {
        return this.physicsComponent.getCollisionBox();
    }

    public Vector2 getTextureRegionPos() {
        return this.config.getTextureRegionPos();
    }

    public void setConfig(EntityConfig _config) {
        this.config = _config;
    }

    public EntityConfig getConfig() { return this.config; }

    public void setTexture(Texture spritesheet) {
        this.graphicsComponent.setTexture(spritesheet, this);
    }


}
