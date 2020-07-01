package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.Component;

import java.util.ArrayList;

public class Projectile {

    protected Vector2 position;
    protected Vector2 velocity;

    protected Rectangle collisionBox;

    protected TextureRegion region;



    public Projectile() {
        position = new Vector2();
        velocity = new Vector2(0f, 12.0f);

    }

    public void update(float delta) {
        position.add(velocity);
        collisionBox.setPosition(position);
    }

    public void render(SpriteBatch batch) {
        batch.draw(region, position.x, position.y, 32, 32);
    }

    public boolean collision(ArrayList<Entity> entities) {

        boolean collision = false;

        for ( Entity e : entities ) {
            if ( this.collisionBox.overlaps(e.getCollisionBox()) ) {
//                System.out.println("Hit!!");
                collision = true;
                e.sendMessage(Component.MESSAGE.DAMAGE, "10");
            }
        }

        return collision;

    }

    public void setPosition(Vector2 _position) {
        this.position = _position;
    }

    public Vector2 getPosition() { return this.position; }

    public void setTextureRegion(TextureRegion _region) {
        this.region = new TextureRegion(_region);
    }

    public void setCollisionBox() {
        collisionBox = new Rectangle(position.x, position.y, 4, 10);
    }

}
