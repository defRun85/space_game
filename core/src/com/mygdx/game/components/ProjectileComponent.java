package com.mygdx.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MainClass;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Projectile;

import java.util.ArrayList;

public class ProjectileComponent implements Component{

    protected ArrayList<Projectile> projectiles;

    public ProjectileComponent() {
        setProjectiles(new ArrayList<Projectile>());
    }

    public void update(float delta, Array<Entity> entities) {
        for ( Projectile p : projectiles ) {
            if ( p.getPosition().y > MainClass.HEIGHT ) {
                removeProjectile(p);
            } else {
                p.update(delta, entities);
            }
        }
    }
    public void render(SpriteBatch batch) {
        for ( Projectile p : projectiles ) {
            p.render(batch);
        }
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(ArrayList<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public void addProjectile(Vector2 projectilePosition) {
        Projectile projectile = new Projectile(new ProjectilePhysicsComponent(), new ProjectileGraphicsComponent());
        projectile.setPosition(projectilePosition);
        projectiles.add(projectile);
    }

    public void removeProjectile(Projectile _projectile) {
        projectiles.remove(_projectile);
    }

    @Override
    public void receiveMessage(String message) {
        String[] string = message.split(TOKEN);

        int len = string.length;

        switch (len) {

            case 0:
                return;

            case 1:
                return;

            case 2:
                // test message for debugging.
                if (string[0].equalsIgnoreCase(MESSAGE.TEST_MESSAGE.toString())) {
                    System.out.println("test message received: " + string[1]);
                }

                if (string[0].equalsIgnoreCase(MESSAGE.FIRE.toString())) {

                    String[] position = string[1].split(", ");

                    for ( String s : position ) {

                    }

                    System.out.println("Player Firing!! : " + string[1]);



                }
                break;

            default:
                break;

        }
    }
}
