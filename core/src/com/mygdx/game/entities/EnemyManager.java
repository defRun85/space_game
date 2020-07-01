package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MainClass;
import com.mygdx.game.components.Component;

import java.util.ArrayList;

import static com.mygdx.game.components.Component.TOKEN;

public class EnemyManager {

    private final Array<Integer> layers;
    protected int layerIndex = 0;
    protected EntityFactory factory;

    protected int boundary = 50;

    protected int maxEnemies = 18;

    protected ArrayList<Entity> enemies;
    int startXPos = 51;
    int startYPos = MainClass.HEIGHT - 50;

    public EnemyManager(EntityFactory _factory) {
        this.factory = _factory;
        enemies = initEnemies();

        layers = new Array<Integer>();

        int layer_width = 35;
        int n_layers = 50;

        for ( int i = 0; i < n_layers; i++ ) {
            int layerY = startYPos - ( i * layer_width );
            layers.add(layerY);
        }

    }

    public ArrayList<Entity> initEnemies() {

        ArrayList<Entity> _enemies = new ArrayList<Entity>();

        Entity enemy = null;

        for (int i = 0; i < getMaxEnemies(); i ++ ) {

            if ( startXPos > 360 ) {
                startXPos = 51;
                startYPos -= 40;
            }

            enemy = factory.getEntity(EntityFactory.EntityType.ENEMY);
            enemy.setPosition(new Vector2(startXPos, startYPos));
            _enemies.add(enemy);
            startXPos += 60;
        }

        return _enemies;
    }

    public void render(SpriteBatch batch) {
        for ( Entity enemy : getEnemies()) {
            enemy.render(batch);
        }



    }

    public void update(float delta) {

        for ( int i = 0; i < enemies.size(); i++ ) {
            if ( enemies.get(i).getHealthPoints() <= 0 ) {
                enemies.remove(enemies.get(i));
            }
        }

        boolean left = false;
        boolean right = false;
        boolean down = false;

        if ( enemies.size() > 0 ) {

            float leftXpos = getLeftEnemyXpos();
            float rightXpos = getRightEnemyXpos();

            if ( leftXpos < boundary ) {
                Entity e = getLowestEnemy();
                if ( e.getPosition().y < layers.get(layerIndex) ) {
                    layerIndex ++;
                    left = false;
                    right = true;
                    down = false;
                } else {
                    down = true;
                }
            }

            if ( rightXpos + 48 > MainClass.WIDTH - boundary ) {
                Entity e = getLowestEnemy();
                if ( e.getPosition().y < layers.get(layerIndex) ) {
                    layerIndex ++;
                    left = true;
                    right = false;
                    down = false;
                } else {
                    down = true;
                }
            }

            if ( left ) {
                setEnemiesState(Component.MESSAGE.STATE, Entity.State.MOVE_LEFT.toString());
            }

            if ( right ) {
                setEnemiesState(Component.MESSAGE.STATE, Entity.State.MOVE_RIGHT.toString());
            }

            if ( down ) {
                setEnemiesState(Component.MESSAGE.STATE, Entity.State.MOVE_DOWN.toString());
            }

            for ( Entity enemy : enemies ) {
                enemy.update(delta);
            }

        }



    }

    public float getLeftEnemyXpos() {

        float leftXpos = 0;

        for ( Entity e : enemies ) {

            if ( leftXpos == 0 ) {
                leftXpos = e.getPosition().x;
            } else if ( leftXpos > 0 && e.getPosition().x < leftXpos ) {
                leftXpos = e.getPosition().x;
            }

        }

        return leftXpos;
    }

    public float getRightEnemyXpos() {

        float rightXpos = 0;

        for ( Entity e : enemies ) {
            if ( rightXpos == 0 ) {
                rightXpos = e.getPosition().x;
            } else if ( rightXpos > 0 && e.getPosition().x > rightXpos ) {
                rightXpos = e.getPosition().x;
            }
        }

        return rightXpos;
    }

    public Entity getLowestEnemy() {

        Entity enemy = null;

        for ( Entity e : enemies ) {
            if ( enemy == null ) {
                enemy = e;
            } else if ( e.getPosition().y < enemy.getPosition().y ) {
                enemy = e;
            }
        }

        return enemy;

    }

    public void setEnemiesState(Component.MESSAGE type, String message) {

        String string = type + TOKEN + message;

        for ( Entity enemy : enemies ) {
            enemy.physicsComponent.receiveMessage(string);
//            System.out.println("State set!!");
        }

    }


    public int getMaxEnemies() {
        return this.maxEnemies;
    }

    public void setMaxEnemies(int _maxEnemies) {
        this.maxEnemies = _maxEnemies;
    }

    public ArrayList<Entity> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(ArrayList<Entity> _enemies) {
        this.enemies = _enemies;
    }

}
