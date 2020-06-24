package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.MainClass;

public class MainGameScreen extends GameScreen {

    protected Skin skin;
    protected Stage stage;

    public MainGameScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        super(_batch, _screenManager);

        stage = new Stage();
        skin = screenManager.getAssetLoader().getSkin();

        Label screenLabel = new Label("Main Game Screen", skin, "default");
        screenLabel.setPosition(10, MainClass.HEIGHT - 25);

        stage.addActor(screenLabel);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update(delta);
        clearScreen();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(background, 0, 0);

        batch.end();

        stage.act();
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
