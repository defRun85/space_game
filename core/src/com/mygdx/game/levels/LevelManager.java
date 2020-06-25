package com.mygdx.game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

public class LevelManager {

    protected static Level currentLevel;

    protected Json json = new Json();

    protected final String levelConfigPath = "json/levels.json";

    protected Array<Level> levels;

    public LevelManager() {

        initLevels();

        setCurrentLevel(0);

    }

    public void initLevels() {

        levels = new Array<Level>();

        ArrayList<JsonValue> levelConfigs = json.fromJson(ArrayList.class, Gdx.files.internal(levelConfigPath));

        for ( JsonValue value : levelConfigs ) {
            levels.add(json.readValue(Level.class, value));
        }
    }

    public Array<Level> getLevelConfigs() {

        return this.levels;

    }

    public void setCurrentLevel(int level) {
        this.currentLevel = levels.get(level);
    }

    public static Level getCurrenLevel() {
        return currentLevel;
    }

    public int getMaxEnemies() {
        return this.currentLevel.getMaxEnemies();
    }

}

