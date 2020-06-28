package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Projectile;

public abstract class GraphicsComponent implements Component, Disposable {

    protected TextureRegion region;
    protected int drawSize = 48;
    protected int regionSize = 32;

    public GraphicsComponent() {

    }

    public abstract void render(SpriteBatch batch, Entity _entity);
    public abstract void render(SpriteBatch batch, Projectile _projectile);

    public void setTexture(Texture spriteSheet, Entity entity) {
        int x = (int) (entity.getTextureRegionPos().x);
        int y = (int) (entity.getTextureRegionPos().y);

        region = new TextureRegion(spriteSheet, x, y, regionSize, regionSize);
    }

    public void setTexture(Texture spriteSheet, Projectile projectile) {
        int x = (int) (projectile.getTextureRegionPos().x);
        int y = (int) (projectile.getTextureRegionPos().y);

        region = new TextureRegion(spriteSheet, x, y, regionSize, regionSize);
    }

}
