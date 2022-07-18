package util;

import java.util.Random;

public class Dice {

    public static int generateValue(int limit) {
        return new Random().nextInt(limit + 1);
    }
}
