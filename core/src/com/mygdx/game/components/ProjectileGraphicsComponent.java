package com.mygdx.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Projectile;

public class ProjectileGraphicsComponent extends GraphicsComponent {



    @Override
    public void render(SpriteBatch batch, Entity _entity) {

    }

    @Override
    public void render(SpriteBatch batch, Projectile _projectile) {
        batch.draw(region, _projectile.getPosition().x, _projectile.getPosition().y);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void receiveMessage(String message) {

    }
}
