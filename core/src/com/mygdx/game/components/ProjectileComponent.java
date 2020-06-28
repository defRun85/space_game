package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.AssetLoader;
import com.mygdx.game.MainClass;
import com.mygdx.game.entities.Entity;

import com.mygdx.game.entities.Projectile;

import java.util.ArrayList;

public class ProjectileComponent implements Component{

    protected ArrayList<Projectile> projectiles;
    protected final String PROJECTILE_CONFIG_PATH = "json/projectile.json";

    public ProjectileComponent() {
        setProjectiles(new ArrayList<Projectile>());
    }

    public void update(float delta, Array<Entity> entities) {
        for ( Projectile p : projectiles ) {
            p.update(delta, entities);
        }

        for ( int i = projectiles.size() - 1; i > 0; i-- ) {
            if ( projectiles.get(i).getPosition().y > MainClass.HEIGHT ) {
                removeProjectile(projectiles.get(i));
            }
        }

//        if ( p.getPosition().y > MainClass.HEIGHT ) {
//            removeProjectile(p);
//        }
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
        Projectile projectile = getProjectile(PROJECTILE_CONFIG_PATH);
        projectile.setPosition(projectilePosition);
        projectile.setTexture(AssetLoader.getSpritesheet());
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

                    System.out.println("Player Firing!! : " + string[1]);

                    String[] st = string[1].split(",");

                    st[0] = st[0].replaceAll("[^0-9?!\\.]","");
                    st[1] = st[1].replaceAll("[^0-9?!\\.]","");


                    for ( String s : st ) {
                        System.out.println(s);
                    }

                    float x = Float.valueOf(st[0]);
                    float y = Float.valueOf(st[1]);

                    Vector2 pos = new Vector2(x, y);

                    addProjectile(pos);

                }
                break;

            default:
                break;

        }
    }

    public Projectile getProjectile(String _configPath) {
        Json json = new Json();
        return json.fromJson(Projectile.class, Gdx.files.internal(_configPath));
    }

}
