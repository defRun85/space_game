package com.mygdx.game.entities;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MainClass;

public class EnemyManager {

    protected EntityFactory factory;

    protected int nEnemies = 6;

    protected Array<Entity> enemies;


    public EnemyManager(EntityFactory _factory) {
        this.factory = _factory;
        enemies = new Array<Entity>();
        initEnemies();
    }

    public void initEnemies() {

        Entity enemy = null;

        int startXPos = 50;
        int startYPos = MainClass.HEIGHT - 50;

        for (int i = 0; i < nEnemies; i ++ ) {
            enemy = factory.getEntity(EntityFactory.EntityType.ENEMY);
            enemy.setPosition(new Vector2(startXPos, startYPos));
            enemies.add(enemy);
            startXPos += 48;
        }
    }

    public void render(SpriteBatch batch) {
        for ( Entity enemy : enemies ) {
            enemy.render(batch);
        }
    }

    public void update(float delta) {

    }


}
