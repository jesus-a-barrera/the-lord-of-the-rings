package entity;

import util.Dice;

public abstract class Beast extends Entity {

    private final int DICE_LIMIT;

    public Beast(int life) {
        super(life);
        DICE_LIMIT = 90;
    }

    @Override
    public int throwDice() {
        return Dice.generateValue(DICE_LIMIT);
    }
}
