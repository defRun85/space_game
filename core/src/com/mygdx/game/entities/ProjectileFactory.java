package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.ProjectileGraphicsComponent;
import com.mygdx.game.components.ProjectilePhysicsComponent;
import com.mygdx.game.screens.ScreenManager;

public class ProjectileFactory {

    protected final String PROJECTILE_CONFIG_PATH = "json/projectile.json";

    protected ScreenManager screenManager;

    public ProjectileFactory(ScreenManager _screenManager) {
        this.screenManager = _screenManager;
    }

    public Projectile getProjectile(Vector2 _startPosition) {

        Projectile projectile = new Projectile(new ProjectilePhysicsComponent(), new ProjectileGraphicsComponent());
        projectile.setPosition(_startPosition);
        return projectile;

    }

}
