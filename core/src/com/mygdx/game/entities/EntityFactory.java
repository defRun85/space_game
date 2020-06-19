package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.PlayerGraphicsComponent;
import com.mygdx.game.components.PlayerPhysicsComponent;

public class EntityFactory {

    private Json json = new Json();

    protected Texture spritesheet;

//    protected final String SPRITESHEET_PATH = "gfx/spritesheet.png";

    protected final String SPRITESHEET_PATH = "gfx/space_sprite_sheet.png";

    protected final static String PLAYER_CONFIG_PATH = "json/player.json";
    protected final static String ENEMY_CONFIG_PATH = "json/enemy.json";

    public enum EntityType {

        TEST_ENTITY,
        PLAYER,
        ENEMY

    }

    public EntityFactory() {
        spritesheet = new Texture(Gdx.files.internal(SPRITESHEET_PATH));
    }

    public Entity getEntity(EntityType type) {

        Entity entity = null;

        switch (type) {

            case TEST_ENTITY:
                entity = new Entity(new PlayerPhysicsComponent(), new PlayerGraphicsComponent());
                EntityConfig playerConfig = getEntityConfig(PLAYER_CONFIG_PATH);
                entity.setConfig(playerConfig);
                entity.setTexture(spritesheet);
                entity.sendMessage(Component.MESSAGE.STATE, json.toJson(entity.getConfig().getState()));
                entity.init();
                return entity;

//            case PLAYER:
//                return null;
//                break;
//
            case ENEMY:
                entity = new Entity(new PlayerPhysicsComponent(), new PlayerGraphicsComponent());
                EntityConfig enemyConfig = getEntityConfig(ENEMY_CONFIG_PATH);
                entity.setConfig(enemyConfig);
                entity.setTexture(spritesheet);
                entity.sendMessage(Component.MESSAGE.STATE, json.toJson(entity.getConfig().getState()));
                entity.init();
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
