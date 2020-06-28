package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.GraphicsComponent;
import com.mygdx.game.components.PhysicsComponent;

import java.util.ArrayList;

public class Projectile {

    private final float velocity = 5.0f;
    private Vector2 position;

    protected ArrayList<Component> components;
    protected PhysicsComponent physicsComponent;
    protected GraphicsComponent graphicsComponent;

    public Projectile(PhysicsComponent _physicsComponent, GraphicsComponent _graphicsComponent) {

        this.components = new ArrayList<Component>();
        this.physicsComponent = _physicsComponent;
        this.graphicsComponent = _graphicsComponent;
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
}
