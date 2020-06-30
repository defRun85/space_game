package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MainClass;
import com.mygdx.game.components.Component;

import java.util.ArrayList;

public class ProjectileManager implements Component {

    protected ArrayList<Projectile> projectiles;

    protected Entity entity;
    protected ProjectileFactory projectileFactory;

    public ProjectileManager(Entity _entity) {
        projectiles = new ArrayList<Projectile>();
        projectileFactory = new ProjectileFactory();
        this.entity = _entity;
    }

    public void addProjectile() {
        Projectile p = projectileFactory.getProjectile();
        Vector2 position = entity.getPosition().cpy();
        p.setPosition(position);
        projectiles.add(p);
    }

    public void removeProjectile(Projectile _projectile) {
        projectiles.remove(_projectile);
    }

    public void update(float delta, Array<Entity> entities) {
        for ( int i = 0; i < projectiles.size(); i++ ) {
            if ( projectiles.get(i).collision(entities) ) {
//                System.out.println("Hit!!");
                removeProjectile(projectiles.get(i));
            }
        }

        for ( int i = 0; i < projectiles.size(); i++ ) {
            if ( projectiles.get(i).getPosition().y > MainClass.HEIGHT ) {
                System.out.println("removing, left screen. " + projectiles.size());
                removeProjectile(projectiles.get(i));
            }
        }

        for ( Projectile p : projectiles ) {
            p.update(delta);
        }

    }

    public void render(SpriteBatch batch) {
        for ( Projectile p : projectiles ) {
            p.render(batch);
        }
    }

    @Override
    public void receiveMessage(String message) {
        String[] string = message.split(TOKEN);

        if ( string[0].equalsIgnoreCase(MESSAGE.FIRE.toString()) ) {
//            System.out.println(string[1]);
            addProjectile();
        }

    }
}
