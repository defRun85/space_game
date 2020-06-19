package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;

public class EntityConfig {

    protected String entityID;
    protected Entity.State state;

    protected float healthPoints;

    protected Vector2 textureRegionPos;
    protected Vector2 startPosition;

    protected float collisionBoxSize;


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

    public Vector2 getTextureRegionPos() {
        return textureRegionPos;
    }

    public void setTextureRegionPos(Vector2 textureRegionPos) {
        this.textureRegionPos = textureRegionPos;
    }

    public Vector2 getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Vector2 startPosition) {
        this.startPosition = startPosition;
    }

    public float getCollisionBoxSize() {
        return collisionBoxSize;
    }

    public void setCollisionBoxSize(float collisionBoxSize) {
        this.collisionBoxSize = collisionBoxSize;
    }

    public float getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(float healthPoints) {
        this.healthPoints = healthPoints;
    }
}
