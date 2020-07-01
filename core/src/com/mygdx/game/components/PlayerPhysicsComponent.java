package com.mygdx.game.components;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MainClass;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class PlayerPhysicsComponent extends PhysicsComponent {

    protected Entity.State currentState;

    protected float velocity = 5.0f;

    public PlayerPhysicsComponent() {

    }

    // PLAYER UPDATE.
    @Override
    public void update(Entity entity, float delta, ArrayList<Entity> entities) {

        switch (currentState) {
            case MOVE_LEFT:
                entity.getPosition().add(-velocity, 0);
                break;
            case MOVE_RIGHT:
                entity.getPosition().add(velocity, 0);
                break;
            default:
                break;
        }

        isCollisionWithEntity(entity, entities);

        checkBoundaries(entity);
        updateCollisionBox();



    }

    // stop using this for player when enemies have been implemented.
    @Override
    public void update(Entity entity, float delta) {

        switch (currentState) {
            case MOVE_LEFT:
                entity.getPosition().add(-velocity, 0);
                break;
            case MOVE_RIGHT:
                entity.getPosition().add(velocity, 0);
                break;
            default:
                break;
        }

        checkBoundaries(entity);
        updateCollisionBox();

    }

    @Override
    public void checkBoundaries(Entity entity) {

        int boundary = 50;

        if ( entity.getPosition().x > MainClass.WIDTH - (boundary + entity.getCollisionBoxSize()) ) {
            entity.setPosition(new Vector2(MainClass.WIDTH - (boundary + entity.getCollisionBoxSize()), entity.getPosition().y));
        } else if ( entity.getPosition().x < boundary ) {
            entity.setPosition(new Vector2(boundary, entity.getPosition().y));
        }
    }

    @Override
    public void receiveMessage(String message) {

        String[] string = message.split(TOKEN);

        int len = string.length;

        switch (len) {

            case 0:
                return;

            case 1:
                return;

            case 2:
                // test message for debugging.
                if ( string[0].equalsIgnoreCase(MESSAGE.TEST_MESSAGE.toString()) ) {
                    System.out.println("test message received: " + string[1]);
                }

                // set the current state of the entity.
                if ( string[0].equalsIgnoreCase(MESSAGE.STATE.toString()) ) {
                    currentState = json.fromJson(Entity.State.class, string[1]);
                }

                if ( string[0].equalsIgnoreCase(MESSAGE.COLLISION.toString()) ) {
                    System.out.println("Player : " + string[1]);
                }

                break;

            default:
                break;

        }

    }

    @Override
    public void dispose() {

    }
}
