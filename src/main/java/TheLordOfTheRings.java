public class TheLordOfTheRings {
    private Turn turn;
    private Army heroes;
    private Army beasts;

    public TheLordOfTheRings() {
        turn = new Turn();
        heroes = turn.createHeroesArmy();
        beasts = turn.createBeastsArmy();
        turn = new Turn(heroes, beasts);
    }

    public void run() {
        System.out.println("Welcome to the game!");
        turn.play();
        turn.printResult();
        System.out.println("Thanks for playing!");
    }
}
