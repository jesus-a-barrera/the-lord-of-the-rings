package entity;

import util.Dice;

public abstract class Hero extends Entity {

    private final int DICE_LIMIT;

    public Hero(int life) {
        super(life);
        DICE_LIMIT = 100;
    }

    @Override
    public int throwDice() {
        int a = Dice.generateValue(DICE_LIMIT);
        int b = Dice.generateValue(DICE_LIMIT);
        return (a > b) ? a : b;
    }

}
