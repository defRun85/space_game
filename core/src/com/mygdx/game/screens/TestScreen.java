package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityFactory;

public class TestScreen extends GameScreen {

    protected EntityFactory factory;

    protected Entity player, enemy;

    protected ShapeRenderer shapeRenderer;

    public TestScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        super(_batch, _screenManager);
        factory = new EntityFactory();
    }

    @Override
    public void update(float delta) {
        player.update(delta);
        enemy.update(delta);
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
