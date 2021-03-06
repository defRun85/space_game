package com.mygdx.game.components;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public abstract class PhysicsComponent implements Component, Disposable {

    protected Json json = new Json();

    protected Vector2 pos;
//    protected float vel = 5.0f;

    protected Rectangle collisionBox;
    protected float collisionBoxOffset = 10.0f;

    public PhysicsComponent() {
        this.collisionBox = new Rectangle();
    }

    public abstract void update(Entity entity, float delta, ArrayList<Entity> entities);
    public abstract void update(Entity entity, float delta);

    public abstract void checkBoundaries(Entity entity);

    public boolean isCollisionWithEntity(Entity entity, ArrayList<Entity> entities) {
        boolean isCollision = false;

        for ( Entity e : entities ) {

            if ( entity.getCollisionBox().overlaps(e.getCollisionBox()) ) {
                entity.sendMessage(MESSAGE.COLLISION, "Entity/Entity Collision Detected");
                isCollision = true;
            } else {
                isCollision = false;
            }

        }

        return isCollision;
    }

    public Rectangle getCollisionBox() {
        return this.collisionBox;
    }

    public void updateCollisionBox(Entity entity) {

        float x = entity.getPosition().x + collisionBoxOffset;
        float y = entity.getPosition().y + collisionBoxOffset;

        Vector2 colBoxPos = new Vector2(x, y);

        collisionBox.setPosition(colBoxPos);
    }

    public void setCollisionBox(Entity entity) {

        float x = this.pos.x + collisionBoxOffset;
        float y = this.pos.y + collisionBoxOffset;

        collisionBox.set(x, y, entity.getCollisionBoxSize(), entity.getCollisionBoxSize());
    }

    public Vector2 getPosition() {
        return this.pos;
    }

    public void setPosition(Vector2 _position) {
        this.pos = _position;
    }

}
