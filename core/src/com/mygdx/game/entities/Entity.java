package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.GraphicsComponent;
import com.mygdx.game.components.PhysicsComponent;

import java.util.ArrayList;

import static com.mygdx.game.components.Component.TOKEN;

public class Entity {

    protected EntityConfig config;

    protected ArrayList<Component> components;
    protected PhysicsComponent physicsComponent;
    protected GraphicsComponent graphicsComponent;

    public enum State {
        MOVE_LEFT,
        MOVE_RIGHT,
        MOVE_UP,
        MOVE_DOWN,
        IDLE
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

    public void update(float delta) {
        physicsComponent.update(delta, this);
    }

    public void update(float delta, ArrayList<Entity> entities) {
        physicsComponent.update(delta, this, entities);
    }

    public void render(SpriteBatch batch) {
        this.graphicsComponent.render(batch, this);
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
