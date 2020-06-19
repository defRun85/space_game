package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.screens.ScreenManager;

public class MainClass extends Game {

	public static final int WIDTH = 580, HEIGHT = 720;
	public static final String TITLE = "Invaders From Space!!..";

	protected ScreenManager screenManager;
	
	@Override
	public void create () {
		screenManager = new ScreenManager(this);
		screenManager.setScreen(ScreenManager.ScreenType.TEST_SCREEN);
	}

	@Override
	public void render () {
		super.render();

		// exit on escape.
		if ( Gdx.input.isKeyPressed(Input.Keys.ESCAPE) ) {
			System.exit(0);
		}
	}
}
