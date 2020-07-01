package com.mygdx.game.components;

public interface Component {

    String TOKEN = " ::: ";

    enum MESSAGE {
        TEST_MESSAGE,
        COLLISION,
        STATE,
        FIRE,
        DAMAGE
    }

    void receiveMessage(String message);

}
