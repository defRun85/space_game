package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.MainClass;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityFactory;

public class TestScreen extends GameScreen {

    protected EntityFactory factory;

    protected Skin skin;
    protected Stage stage;


    protected Entity player;

    public TestScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        super(_batch, _screenManager);
        factory = new EntityFactory();

        stage = new Stage();
        skin = screenManager.getAssetLoader().getSkin();

        Label screenLabel = new Label("Test Screen", skin, "white");
        screenLabel.setPosition(10, MainClass.HEIGHT - 25);

        stage.addActor(screenLabel);

        player = factory.getEntity(EntityFactory.EntityType.PLAYER);

    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {

        player.update(delta);

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
