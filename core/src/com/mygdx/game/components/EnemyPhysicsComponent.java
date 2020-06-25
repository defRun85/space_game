package com.mygdx.game.components;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class EnemyPhysicsComponent extends PhysicsComponent {

    protected Entity.State currentState;

    public EnemyPhysicsComponent() {

    }

    // PLAYER UPDATE.
    @Override
    public void update(Entity entity, float delta, Array<Entity> _entities) {

    }

    // ENEMY UPDATE.
    @Override
    public void update(Entity entity, float delta) {

//        System.out.println(currentState);

        switch (currentState) {

            case MOVE_RIGHT:
                entity.getPosition().add(vel, 0);
                break;
            case MOVE_LEFT:
                entity.getPosition().add(-vel, 0);
                break;
            case MOVE_DOWN:
                entity.getPosition().add(0, -vel);
                break;
            default:
                break;

        }

        updateCollisionBox();



    }

    @Override
    public void checkBoundaries(Entity entity) {

    }

    @Override
    public void receiveMessage(String message) {

//        System.out.println("Message Received!!");

        String[] string = message.split(TOKEN);

        int len = string.length;

        switch (len) {

            case 0:
                return;

            case 1:
                return;

            case 2:
                if ( string[0].equalsIgnoreCase(MESSAGE.STATE.toString()) ) {
                    currentState = json.fromJson(Entity.State.class, string[1]);
//                    System.out.println(currentState);
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

