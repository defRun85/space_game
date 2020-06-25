package com.mygdx.game.levels;

public class Level {

    private int level;
    protected int maxEnemies;

    public Level() {

    }

    public int getMaxEnemies() {
        return maxEnemies;
    }

    public void setMaxEnemies(int maxEnemies) {
        this.maxEnemies = maxEnemies;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
