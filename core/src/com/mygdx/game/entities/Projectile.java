package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.components.*;

import java.util.ArrayList;

public class Projectile {

    protected String entityID;
    protected int collisionBoxSize;
    protected Vector2 textureRegionPos;

    private final float velocity = 5.0f;
    private Vector2 position;

    protected ArrayList<Component> components;
    protected PhysicsComponent physicsComponent;
    protected GraphicsComponent graphicsComponent;

    public Projectile() {

        this.components = new ArrayList<Component>();
        this.physicsComponent = new ProjectilePhysicsComponent();
        this.graphicsComponent = new ProjectileGraphicsComponent();

        components.add(physicsComponent);
        components.add(graphicsComponent);

    }

    public void update(float delta, Array<Entity> entities) {

        physicsComponent.update(this, delta, entities);

    }

    public float getVelocity() {
        return this.velocity;
    }

    public void render(SpriteBatch batch) {
        graphicsComponent.render(batch, this);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }


    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public int getCollisionBoxSize() {
        return collisionBoxSize;
    }

    public void setCollisionBoxSize(int collisionBoxSize) {
        this.collisionBoxSize = collisionBoxSize;
    }

    public Vector2 getTextureRegionPos() {
        return textureRegionPos;
    }

    public void setTextureRegionPos(Vector2 textureRegionPos) {
        this.textureRegionPos = textureRegionPos;
    }

    public void setTexture(Texture spritesheet) {
        this.graphicsComponent.setTexture(spritesheet, this);
    }
}

