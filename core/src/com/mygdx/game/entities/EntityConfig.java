package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;

public class EntityConfig {

    protected String entityID;
    protected Entity.State state;

    protected int healthPoints;
    protected float velocity;

    protected Vector2 textureRegionPos;
    protected Vector2 startPosition;

    protected int collisionBoxSize;

    public EntityConfig() {}

    public String getEntityID() {
        return this.entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public Entity.State getState() {
        return this.state;
    }

    public void setState(Entity.State _state) {
        this.state = _state;
    }

    public Vector2 getTextureRegionPos() {
        return this.textureRegionPos;
    }

    public void setTextureRegionPos(Vector2 textureRegionPos) {
        this.textureRegionPos = textureRegionPos;
    }

    public Vector2 getStartPosition() {
        return this.startPosition;
    }

    public void setStartPosition(Vector2 _startPosition) {
        this.startPosition = _startPosition;
    }

    public int getCollisionBoxSize() {
        return this.collisionBoxSize;
    }

    public void setCollisionBoxSize(int collisionBoxSize) {
        this.collisionBoxSize = collisionBoxSize;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int _healthPoints) {
        this.healthPoints = _healthPoints;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
}
