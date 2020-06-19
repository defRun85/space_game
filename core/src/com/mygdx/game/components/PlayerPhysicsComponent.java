package com.mygdx.game.components;

import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class PlayerPhysicsComponent extends PhysicsComponent {

    protected Entity.State currentState;

    public PlayerPhysicsComponent() {

    }

    @Override
    public void update(float delta, Entity entity, ArrayList<Entity> entities) {

    }

    @Override
    public void update(float delta, Entity entity) {

    }

    @Override
    public void checkBoundaries() {

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

                break;

            default:
                break;

        }

    }
}
