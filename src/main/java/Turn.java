import entity.*;
import util.Dice;

public class Turn {
    private int turnNumber;
    private final int ARMIES_SIZE = 10;
    private Army heroes;
    private Army beasts;
    public Turn() {
    }

    public Turn(Army heroes, Army beasts) {
        turnNumber = 1;
        this.heroes = heroes;
        this.beasts = beasts;
    }

    public Army createHeroesArmy() {
        Hero hero;
        heroes = new Army(ARMIES_SIZE);
        for (int i = 0; i < ARMIES_SIZE; i++) {
            double number = Dice.generateValue(100);
            if (number < 30) {
                hero = new Human();
            } else if (number < 60) {
                hero = new Elf();
            } else {
                hero = new Hobbit();
            }
            hero.setName("Hero" + i); //**************
            heroes.addEntity(hero);
        }
        return heroes;
    }

    public Army createBeastsArmy() {
        Beast beast;
        beasts = new Army(ARMIES_SIZE);
        for (int i = 0; i < ARMIES_SIZE; i++) {
            double number = Dice.generateValue(100);
            if (number < 50) {
                beast = new Orc();
            } else {
                beast = new Gobblin();
            }
            beast.setName("Beast" + i); //**************
            beasts.addEntity(beast);
        }
        return beasts;
    }

    public void play() {
        while (!heroes.isDefeated() && !beasts.isDefeated()) {
            System.out.println("\nTurn " + turnNumber + ": ");
            for (int i = 0; i < ARMIES_SIZE; i++) {
                if (!isAMatch(i)) continue;
                System.out.println();
                printTurn(i);
                executeFight(i);
                printTurn(i);
            }
            heroes.removeCorpses();
            beasts.removeCorpses();
            turnNumber++;
        }
    }

    private boolean isAMatch(int i) {
        Entity hero = heroes.getEntity(i);
        Entity beast = beasts.getEntity(i);
        if (hero != null && beast != null) {
            return true;
        }
        return false;
    }

    private void executeFight(int i) {
        Entity hero = heroes.getEntity(i);
        Entity beast = beasts.getEntity(i);
        double heroAttack = hero.attack(beast);
        beast.getDamage(hero, heroAttack);
        if (!beast.isDead()) {
            double beastAttack = beast.attack(hero);
            hero.getDamage(beast, beastAttack);
        }
    }

    public void printResult() {
        System.out.println("\n**************************");
        if (beasts.isDefeated()) {
            System.out.println("HEROES WON THE GAME!");
        } else {
            System.out.println("BEASTS WON THE GAME!");
        }
        System.out.println("**************************\n");
    }

    private void printTurn(int i) {
        System.out.println(heroes.getEntity(i).getName() + "(" + heroes.getEntity(i).getLife() + ") and " + beasts.getEntity(i).getName() + "(" + beasts.getEntity(i).getLife() + ")");
    }
}
