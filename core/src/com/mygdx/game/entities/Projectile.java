package com.mygdx.game.entities;

import com.mygdx.game.components.GraphicsComponent;
import com.mygdx.game.components.PhysicsComponent;

public class Projectile extends Entity {

    protected ProjectileConfig config;

    public Projectile(PhysicsComponent _physicsComponent, GraphicsComponent _graphicsComponent) {
        super(_physicsComponent, _graphicsComponent);
    }

}
