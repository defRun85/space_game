package com.mygdx.game.components;

import com.mygdx.game.entities.Entity;

import java.util.ArrayList;

public class EnemyPhysicsComponent extends PhysicsComponent {

    protected Entity.State currentState;

    protected float velocity = 3.0f;

    public EnemyPhysicsComponent() {

    }

    // PLAYER UPDATE.
    @Override
    public void update(Entity entity, float delta, ArrayList<Entity> _entities) {

    }

    // ENEMY UPDATE.
    @Override
    public void update(Entity entity, float delta) {

//        System.out.println(currentState);

        switch (currentState) {

            case MOVE_RIGHT:
                entity.getPosition().add(velocity, 0);
                break;
            case MOVE_LEFT:
                entity.getPosition().add(-velocity, 0);
                break;
            case MOVE_DOWN:
                entity.getPosition().add(0, -velocity);
                break;
            default:
                break;

        }

        updateCollisionBox(entity);

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
                if ( string[0].equalsIgnoreCase(MESSAGE.COLLISION.toString()) ) {
                    System.out.println("Enemy : " + string[1]);
//                    System.out.println(currentState);
                }


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

