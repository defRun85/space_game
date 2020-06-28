package com.mygdx.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Projectile;

public class EnemyGraphicsComponent extends GraphicsComponent {

    @Override
    public void render(SpriteBatch batch, Entity entity) {
        batch.draw(region, entity.getPosition().x, entity.getPosition().y, drawSize, drawSize);
    }

    @Override
    public void render(SpriteBatch batch, Projectile _projectile) {

    }

    @Override
    public void receiveMessage(String message) {

    }

    @Override
    public void dispose() {

    }
}
