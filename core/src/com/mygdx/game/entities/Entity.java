package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.*;
import com.mygdx.game.input.PlayerInput;

import java.util.ArrayList;

import static com.mygdx.game.components.Component.TOKEN;

public class Entity {

    protected EntityConfig config;

    protected ArrayList<Component> components;
    protected PhysicsComponent physicsComponent;
    protected GraphicsComponent graphicsComponent;
    protected HealthComponent healthComponent;

    protected PlayerInput playerInput;
    protected ProjectileManager projectileManager;

    public enum State {
        MOVE_LEFT,
        MOVE_RIGHT,
        MOVE_UP,
        MOVE_DOWN,
        IDLE
    }

    public Entity(PhysicsComponent _physicsComponent, GraphicsComponent _graphicsComponent, HealthComponent _healthComponent) {

        this.components = new ArrayList<Component>();

        physicsComponent = _physicsComponent;
        graphicsComponent = _graphicsComponent;
        healthComponent = _healthComponent;

        components.add(physicsComponent);
        components.add(graphicsComponent);
        components.add(healthComponent);

    }

    public void init() {
        setPosition(this.config.getStartPosition());
        this.physicsComponent.setCollisionBox(this);
        projectileManager = new ProjectileManager(this);
        this.healthComponent.setHealthPoints(getConfig().getHealthPoints());
    }

    public void initPlayer(Entity entity) {
        playerInput = new PlayerInput(entity);
        Gdx.input.setInputProcessor(playerInput);
    }

    public String getEntityID() {
        return this.getConfig().getEntityID();
    }

    public void update(float delta) {
        physicsComponent.update(this, delta);
//        System.out.println(getEntityID() + " : " + getHealthPoints());
    }

    public void update(float delta, ArrayList<Entity> entities) {
        physicsComponent.update(this, delta, entities);
        projectileManager.update(delta, entities);

//        System.out.println(getEntityID() + " : " + getHealthPoints());

    }

    public void render(SpriteBatch batch) {
        this.graphicsComponent.render(batch, this);
        projectileManager.render(batch);
    }

    public void sendMessage(Component.MESSAGE type, String message) {

        String messageString = type + TOKEN + message;

        for ( Component component : components ) {
            component.receiveMessage(messageString);
        }

        projectileManager.receiveMessage(messageString);

    }

    public int getHealthPoints() {
        return this.healthComponent.getHealthPoints();
    }

    public Vector2 getPosition() {
        return physicsComponent.getPosition();
    }

    public void setPosition(Vector2 _position) { this.physicsComponent.setPosition(_position); }

    public float getCollisionBoxSize() {
        return this.config.getCollisionBoxSize();
    }

    public Rectangle getCollisionBox() {
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
