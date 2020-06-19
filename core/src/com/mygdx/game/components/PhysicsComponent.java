package com.mygdx.game.components;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public abstract class PhysicsComponent implements Component {

    protected Json json = new Json();

    protected Vector2 pos;
    protected float vel = 6.0f;

    protected Rectangle collisionBox;
    protected float collisionBoxSize = 64.0f;

    public PhysicsComponent() {
        this.collisionBox = new Rectangle();
    }

    public abstract void update(float delta, Entity entity, ArrayList<Entity> entities);
    public abstract void update(float delta, Entity entity);

    public abstract void checkBoundaries();

    public boolean isCollisionWithEntity(Entity entity, ArrayList<Entity> entities) {
        boolean isCollision = false;

        for ( Entity e : entities ) {

            if ( entity.getCollisonBox().overlaps(e.getCollisonBox()) ) {
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

    public void updateCollisionBox() {
        collisionBox.setPosition(pos.x, pos.y);
    }

    public void setCollisionBox(Entity entity) {
        collisionBox.set(entity.getPosition().x, entity.getPosition().y, entity.getCollisionBoxSize(), entity.getCollisionBoxSize());
    }

    public Vector2 getPosition() {
        return this.pos;
    }

    public void setPosition(Vector2 _position) {
        this.pos = _position;
    }

}
