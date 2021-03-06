package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.AssetLoader;
import com.mygdx.game.components.*;
import com.mygdx.game.screens.ScreenManager;

public class EntityFactory {

    private Json json = new Json();

    protected ScreenManager screenManager;

    protected final static String PLAYER_CONFIG_PATH = "json/player.json";
    protected final static String ENEMY_CONFIG_PATH = "json/enemy.json";
    protected final static String PROJECTILE_CONFIG_PATH = "json/projectile.json";

    public enum EntityType {

        TEST_ENTITY,
        PLAYER,
        ENEMY,
        PROJECTILE

    }

    public EntityFactory(ScreenManager _screenManager) {
        this.screenManager = _screenManager;
    }

    public Entity getEntity(EntityType type) {

        Entity entity = null;

        switch (type) {

//            case TEST_ENTITY:
//                entity = new Entity(new PlayerPhysicsComponent(), new PlayerGraphicsComponent());
//                EntityConfig playerConfig = getEntityConfig(PLAYER_CONFIG_PATH);
//                entity.setConfig(playerConfig);
//                entity.setTexture(spritesheet);
//                entity.sendMessage(Component.MESSAGE.STATE, json.toJson(entity.getConfig().getState()));
//                entity.init();
//                return entity;

            case PLAYER:
                entity = new Entity(new PlayerPhysicsComponent(), new PlayerGraphicsComponent(), new HealthComponent());
                EntityConfig playerConfig = getEntityConfig(PLAYER_CONFIG_PATH);
                entity.initPlayer(entity);
                entity.setConfig(playerConfig);
                entity.setTexture(AssetLoader.getSpritesheet());
                entity.init();
                entity.sendMessage(Component.MESSAGE.STATE, json.toJson(entity.getConfig().getState()));
                return entity;

            case ENEMY:
                entity = new Entity(new EnemyPhysicsComponent(), new EnemyGraphicsComponent(), new HealthComponent());
                EntityConfig enemyConfig = getEntityConfig(ENEMY_CONFIG_PATH);
                entity.setConfig(enemyConfig);
                entity.setTexture(AssetLoader.getSpritesheet() );
                entity.init();
                entity.sendMessage(Component.MESSAGE.STATE, json.toJson(entity.getConfig().getState()));
                return entity;

            default:
                return null;

        }
    }

    public EntityConfig getEntityConfig(String _configPath) {
        Json json = new Json();
        return json.fromJson(EntityConfig.class, Gdx.files.internal(_configPath));
    }

}
