package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;

public class ProjectileConfig {

    protected String entityID;
    protected Entity.State state;
    protected int collisionBoxSize;
    protected Vector2 textureRegionPos;
    protected float velocity;

    public ProjectileConfig() {}


    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public Entity.State getState() {
        return state;
    }

    public void setState(Entity.State state) {
        this.state = state;
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

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
}
