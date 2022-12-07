package org.cal.examen;

import java.util.Random;

public class GameRunner {
    static final int NUMBER_OF_CARDS = 50;

    private static boolean notAWinner;

    public static void main(String[] args) {
        Game aGame = new Game(NUMBER_OF_CARDS);

        aGame.addPlayer("Mathieu");
        aGame.addPlayer("Samir");
        aGame.addPlayer("Manolo");

        Random rand = new Random();
        do {
            aGame.roll(rand.nextInt(5) + 1);
            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
        } while (notAWinner);

    }
}
