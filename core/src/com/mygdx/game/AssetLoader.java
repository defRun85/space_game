package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    protected Skin skin;
    protected Texture spritesheet;

    protected final String SKIN_PATH = "uiskin/skin/lgdxs-ui.json";

    public AssetLoader() {

    }

    public void loadAssets() {
        skin = new Skin(Gdx.files.internal(SKIN_PATH));
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Texture getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(Texture spritesheet) {
        this.spritesheet = spritesheet;
    }
}
