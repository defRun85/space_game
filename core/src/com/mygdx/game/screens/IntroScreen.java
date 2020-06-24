package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    protected BitmapFont fontMain, fontSub;

    public IntroScreen(SpriteBatch _batch, final ScreenManager _screenManager) {
        super(_batch, _screenManager);

        stage = new Stage();
        table = new Table();

        table.setFillParent(true);

        skin = screenManager.getAssetLoader().getSkin();
        Color c = new Color(60f/255f,179f/255f,113f/255f, 255);
        screenManager.getAssetLoader().loadFont("fonts/pandora.ttf", 48);

        fontMain = screenManager.assetLoader.getFont();
        fontMain.setColor(c);

        screenManager.getAssetLoader().loadFont("fonts/pandora.ttf", 18);

        fontSub = screenManager.getAssetLoader().getFont();
        fontSub.setColor(c);

        final Label screenLabel = new Label("Intro Screen", skin, "default");
        screenLabel.setPosition(10, MainClass.HEIGHT - 25);


        TextButton quitButton = new TextButton("Quit", skin, "default");
        quitButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });

        TextButton testButton = new TextButton("Test", skin, "default");
        testButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                screenManager.setScreen(ScreenManager.ScreenType.TEST_SCREEN);
            }
        });

        TextButton newGameButton = new TextButton("New Game", skin, "default");
        newGameButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                screenManager.setScreen(ScreenManager.ScreenType.MAIN_GAME_SCREEN);
            }
        });

        Gdx.input.setInputProcessor(stage);

        table.row();
        table.add(testButton);
        table.row();
        table.add(newGameButton);
        table.row();
        table.add(quitButton);

        stage.addActor(table);
        stage.addActor(screenLabel);

    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {

        update(delta);
        clearScreen();

        batch.begin();

        batch.draw(background, 0, 0);

        fontMain.draw(batch, "Invaders", 160, MainClass.HEIGHT - 150);
        fontSub.draw(batch, "from Space...", 250, MainClass.HEIGHT - 210);

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
