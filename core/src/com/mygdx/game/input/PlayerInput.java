package com.mygdx.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.components.Component;
import com.mygdx.game.entities.Entity;

public class PlayerInput implements InputProcessor {

    protected Entity player;

    public PlayerInput(Entity _player) {
        this.player = _player;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {

            case Input.Keys.A:
                player.sendMessage(Component.MESSAGE.STATE, Entity.State.MOVE_LEFT.toString());
                break;

            case Input.Keys.D:
                player.sendMessage(Component.MESSAGE.STATE, Entity.State.MOVE_RIGHT.toString());
                break;

//            case Input.Keys.SPACE:
//                player.sendMessage(Component.MESSAGE.FIRE, player.getPosition().toString());
//                break;

            default:
                break;

        }

        if ( keycode == Input.Keys.SPACE ) {
            player.sendMessage(Component.MESSAGE.FIRE, "Firing!!");
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        switch (keycode) {

            case Input.Keys.A:
                player.sendMessage(Component.MESSAGE.STATE, Entity.State.IDLE.toString());
                break;

            case Input.Keys.D:
                player.sendMessage(Component.MESSAGE.STATE, Entity.State.IDLE.toString());
                break;

            default:
//                player.sendMessage(Component.MESSAGE.STATE, Entity.State.IDLE.toString());
                break;

        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
