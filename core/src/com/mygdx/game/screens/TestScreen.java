package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.EntityFactory;

public class TestScreen extends GameScreen {

    protected EntityFactory factory;

    public TestScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        super(_batch, _screenManager);
        factory = new EntityFactory();
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
