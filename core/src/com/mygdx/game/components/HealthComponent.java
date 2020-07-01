package com.mygdx.game.components;

public class HealthComponent implements Component {

    protected int healthPoints;

    public HealthComponent() {

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
                if ( string[0].equalsIgnoreCase(MESSAGE.DAMAGE.toString()) ) {
                    doDamage(Integer.valueOf(string[1]));
                }
        }
    }

    public void doDamage(int _damage) {
        this.healthPoints -= _damage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
