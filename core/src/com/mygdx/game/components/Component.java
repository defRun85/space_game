package com.mygdx.game.components;

public interface Component {

    String TOKEN = " ::: ";

    enum MESSAGE {
        TEST_MESSAGE,
        COLLISION,
        STATE
    }

    void receiveMessage(String message);

}
