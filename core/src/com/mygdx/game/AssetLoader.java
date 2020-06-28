package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    protected Skin skin;
    protected static Texture spritesheet;

    protected BitmapFont font;

    protected final String SKIN_PATH = "uiskin/skin/star-soldier-ui.json";
    //    protected final String SPRITESHEET_PATH = "gfx/space_sprite_sheet.png";
    protected final String SPRITESHEET_PATH = "gfx/space_proto_sheet.png";

    public AssetLoader() {
        font = null;
        skin = null;
        spritesheet = null;
    }

    public void loadAssets() {

        if ( skin == null ) {
            skin = new Skin(Gdx.files.internal(SKIN_PATH));
        }

        // spritesheet & font...
        if ( spritesheet == null ) {
            spritesheet = new Texture(Gdx.files.internal(SPRITESHEET_PATH));
        }
    }

    public void loadFont(String _fontPath, int _size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(_fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = _size;
        setFont(generator.generateFont(parameter));
        generator.dispose();
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public static Texture getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(Texture spritesheet) {
        this.spritesheet = spritesheet;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }
}
