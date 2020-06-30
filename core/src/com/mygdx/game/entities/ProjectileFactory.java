package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AssetLoader;

public class ProjectileFactory {

    protected Texture spritesheet;

    public ProjectileFactory() {
        spritesheet = AssetLoader.getSpritesheet();
    }

    public Projectile getProjectile() {

        Projectile p = new Projectile();
        p.setTextureRegion(setProjectileTextureRegion());
        p.setCollisionBox();
        return p;

    }

    public TextureRegion setProjectileTextureRegion() {
        TextureRegion region = new TextureRegion(spritesheet, 64, 0, 32, 32);
        return region;
    }

}
