package com.mygdx.game.entities;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MainClass;
import com.mygdx.game.components.Component;

import static com.mygdx.game.components.Component.TOKEN;

public class EnemyManager {

    private final Array<Integer> layers;
    protected int layerIndex = 0;
    protected EntityFactory factory;

    protected int boundary = 50;

    protected int maxEnemies = 18;

    protected Array<Entity> enemies;
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

    public Array<Entity> initEnemies() {

        Array<Entity> _enemies = new Array<Entity>();

        Entity enemy = null;

        for (int i = 0; i < getMaxEnemies(); i ++ ) {

            if ( startXPos > 291 ) {
                startXPos = 51;
                startYPos -= 40;
            }

            enemy = factory.getEntity(EntityFactory.EntityType.ENEMY);
            enemy.setPosition(new Vector2(startXPos, startYPos));
            _enemies.add(enemy);
            startXPos += 48;
        }

        return _enemies;
    }

    public void render(SpriteBatch batch) {
        for ( Entity enemy : getEnemies()) {
            enemy.render(batch);
        }
    }

    public void update(float delta) {

        boolean left = false;
        boolean right = false;
        boolean down = false;

        float leftXpos = getLeftEnemyXpos();
        float rightXpos = getRightEnemyXpos();

//        System.out.println(leftXpos + " : " + rightXpos);

        // move left or right based of leftXpos and rightXpos values.
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

//        System.out.println("MR: " + right);
//        System.out.println("ML: " + left);
//        System.out.println("MD: " + down);

        for ( Entity enemy : enemies ) {
            enemy.update(delta);
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
        return maxEnemies;
    }

    public void setMaxEnemies(int maxEnemies) {
        this.maxEnemies = maxEnemies;
    }

    public Array<Entity> getEnemies() {
        return enemies;
    }

    public void setEnemies(Array<Entity> enemies) {
        this.enemies = enemies;
    }

}
