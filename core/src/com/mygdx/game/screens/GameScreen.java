package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.EntityFactory;

public abstract class GameScreen implements Screen {

    protected OrthographicCamera camera;
    protected SpriteBatch batch;
    protected ScreenManager screenManager;

    protected EntityFactory factory;
    protected Entity player;

    protected Texture background;
    protected final String BACKGROUND_TEXTURE_PATH = "gfx/bg.png";

    public GameScreen(SpriteBatch _batch, ScreenManager _screenManager) {
        this.batch = _batch;
        this.screenManager = _screenManager;
        factory = new EntityFactory(_screenManager);
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        batch.setProjectionMatrix(camera.combined);
        background = new Texture(Gdx.files.internal(BACKGROUND_TEXTURE_PATH));
    }

    public void clearScreen() {
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public Entity getPlayer() {
        return this.player;
    }

    public abstract void update(float delta);
    public abstract void render(float delta);

}
