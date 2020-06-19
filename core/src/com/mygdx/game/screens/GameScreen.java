package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameScreen implements Screen {

    protected OrthographicCamera camera;
    protected SpriteBatch batch;
    protected ScreenManager screenManager;

    public GameScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        this.batch = _batch;
        this.screenManager = _screenManager;
        camera = new OrthographicCamera();
        batch.setProjectionMatrix(camera.combined);
    }

    public void clearScreen() {
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public abstract void update(float delta);
    public abstract void render(float delta);

}
