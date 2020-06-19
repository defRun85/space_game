package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MainClass;

public class ScreenManager {

    protected MainClass parent;
    protected SpriteBatch batch;

    protected TestScreen testScreen;

    public enum ScreenType {

        TEST_SCREEN,
        INTRO_SCREEN,
        MAIN_GAME_SCREEN

    }

    public ScreenManager(MainClass _parent) {
        this.parent = _parent;
        batch = new SpriteBatch();
    }

    public void setScreen(ScreenType type) {

        switch (type) {

            case TEST_SCREEN:
                if ( testScreen == null ) {
                    testScreen = new TestScreen(batch, this);
                    parent.setScreen(testScreen);
                } else {
                    parent.setScreen(testScreen);
                }
                break;
//            case INTRO_SCREEN:
//                break;
//            case MAIN_GAME_SCREEN:
//                break;
            default:
                break;

        }

    }

}
