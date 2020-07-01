package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.MainClass;
import com.mygdx.game.entities.EnemyManager;
import com.mygdx.game.entities.EntityFactory;
import com.mygdx.game.levels.LevelManager;

public class TestScreen extends GameScreen {

    protected Skin skin;
    protected Stage stage;

//    protected Entity player;
//    protected Entity enemy;

    protected EnemyManager enemyMgr;
    protected LevelManager levelManager;

    public TestScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        super(_batch, _screenManager);

        stage = new Stage();
        skin = screenManager.getAssetLoader().getSkin();

        Label screenLabel = new Label("Test Screen", skin, "default");
        screenLabel.setPosition(10, MainClass.HEIGHT - 25);

        stage.addActor(screenLabel);

        player = factory.getEntity(EntityFactory.EntityType.PLAYER);
//        enemy = factory.getEntity(EntityFactory.EntityType.ENEMY);
        enemyMgr = new EnemyManager(factory);
        enemyMgr.initEnemies();

    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {

        player.update(delta, enemyMgr.getEnemies());

        enemyMgr.update(delta);

        stage.act();
    }

    @Override
    public void render(float delta) {

        update(delta);
        clearScreen();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(background, 0, 0);

        player.render(batch);

        enemyMgr.render(batch);

        batch.end();

        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
