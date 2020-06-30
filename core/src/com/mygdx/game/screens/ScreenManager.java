package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AssetLoader;
import com.mygdx.game.MainClass;
import com.mygdx.game.entities.EntityFactory;

public class ScreenManager {

    protected MainClass parent;
    protected SpriteBatch batch;
    protected AssetLoader assetLoader;

    protected TestScreen testScreen;
    protected IntroScreen introScreen;
    protected MainGameScreen mainGameScreen;

    protected GameScreen currentScreen;

    public enum ScreenType {

        TEST_SCREEN,
        INTRO_SCREEN,
        MAIN_GAME_SCREEN

    }

    public ScreenManager(MainClass _parent) {
        this.parent = _parent;

        assetLoader = new AssetLoader();
        batch = new SpriteBatch();

        assetLoader.loadAssets();

    }

    public void setScreen(ScreenType type) {

        switch (type) {

            case TEST_SCREEN:
                if ( testScreen == null ) {
                    testScreen = new TestScreen(batch, this);
                    currentScreen = testScreen;
                    parent.setScreen(testScreen);
                } else {
                    currentScreen = testScreen;
                    parent.setScreen(testScreen);
                }
                break;

            case INTRO_SCREEN:
                if ( introScreen == null ) {
                    introScreen = new IntroScreen(batch, this);
                    currentScreen = introScreen;
                    parent.setScreen(introScreen);
                } else {
                    currentScreen = introScreen;
                    parent.setScreen(introScreen);
                }
                break;

            case MAIN_GAME_SCREEN:
                if ( mainGameScreen == null ) {
                    mainGameScreen = new MainGameScreen(batch, this);
                    currentScreen = mainGameScreen;
                    parent.setScreen(mainGameScreen);
                } else {
                    currentScreen = mainGameScreen;
                    parent.setScreen(mainGameScreen);
                }
                break;

            default:
                break;

        }

    }

    public GameScreen getCurrentScreen() {
        return this.currentScreen;
    }

    public AssetLoader getAssetLoader() {
        return this.assetLoader;
    }

}
