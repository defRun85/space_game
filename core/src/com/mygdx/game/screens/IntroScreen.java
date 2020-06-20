package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MainClass;

public class IntroScreen extends GameScreen {

    protected Skin skin;
    protected Stage stage;
    protected Table table;


    public IntroScreen(SpriteBatch _batch, final ScreenManager _screenManager) {
        super(_batch, _screenManager);

        stage = new Stage();
        table = new Table();

        table.align(Align.bottomLeft);

        skin = new Skin(Gdx.files.internal("uiskin/skin/lgdxs-ui.json"));

        TextButton testButton = new TextButton("Test Screen", skin, "small1");
        TextButton quitButton = new TextButton("Quit", skin, "small2");

        testButton.setHeight(10);
        quitButton.setHeight(10);

        testButton.addListener(new ClickListener() {

            public void clicked(InputEvent event, float x, float y) {
                screenManager.setScreen(ScreenManager.ScreenType.TEST_SCREEN);
            }

        });

        quitButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });

        Label screenLabel = new Label("Intro Screen", skin, "white");
        screenLabel.setPosition(10, MainClass.HEIGHT - 20);

        table.row().pad(3);
        table.add(testButton);
        table.add(quitButton);

        Gdx.input.setInputProcessor(stage);

        stage.addActor(table);
        stage.addActor(screenLabel);

    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {
        stage.act();
    }

    @Override
    public void render(float delta) {

        update(delta);
        clearScreen();

        batch.begin();

        batch.draw(background, 0, 0);

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
