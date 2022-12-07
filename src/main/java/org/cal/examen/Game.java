package org.cal.examen;

public class Game {
    final int MAX_PLACE_SPOT = 12;

    PlayerManager playerManager;
    QuestionManager questionManager;

    public Game(int nbCards) {
        this.playerManager = new PlayerManager();
        this.questionManager = new QuestionManager(nbCards);
    }

    public void addPlayer(String playerName) {
        playerManager.addPlayer(playerName);
    }

    public void roll(int roll) {
        String currentPlayerName = playerManager.getCurrentPlayerName();
        System.out.println(currentPlayerName + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (playerManager.isCurrentPlayerInPenaltyBox()) {
            attemptToLeavePenaltyBox(roll);
        } else {
            movePlayer(roll);
        }
    }

    public boolean wasCorrectlyAnswered() {
        if (!playerManager.isCurrentPlayerInPenaltyBox()) {
            System.out.println("Answer was correct!!!!");
            playerManager.incrementCurrentPlayerCoins();
            System.out.println(playerManager.getCurrentPlayerName()
                    + " now has "
                    + playerManager.getCurrentPlayerCoins()
                    + " Gold Coins.");
        }

        boolean isWinner = playerManager.hasCurrentPlayerWon();
        playerManager.nextPlayer();
        return isWinner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(playerManager.getCurrentPlayerName() + " was sent to the penalty box");
        playerManager.sendCurrentPlayerToPenaltyBox();
        playerManager.nextPlayer();
        return playerManager.hasCurrentPlayerWon();
    }

    private void attemptToLeavePenaltyBox(int roll) {
        String currentPlayerName = playerManager.getCurrentPlayerName();

        if (roll % 2 == 0) {
            System.out.println(currentPlayerName + " is not getting out of the penalty box");
        } else {
            System.out.println(currentPlayerName + " is getting out of the penalty box");
            playerManager.removeCurrentPlayerFromPenaltyBox();
            movePlayer(roll);
        }
    }

    private Category currentCategory() {
        return switch (playerManager.getCurrentPlayerPlace()) {
            case 0, 4, 8 -> Category.POP;
            case 1, 5, 9 -> Category.SCIENCE;
            case 2, 6 -> Category.SPORTS;
            default -> Category.ROCK;
        };
    }

    private void movePlayer(int roll) {
        String currentPlayerName = playerManager.getCurrentPlayerName();
        int currentPlayerPlace = playerManager.getCurrentPlayerPlace();
        currentPlayerPlace += roll;

        if (currentPlayerPlace >= MAX_PLACE_SPOT) {
            currentPlayerPlace -= MAX_PLACE_SPOT;
        }
        playerManager.setCurrentPlayerPlace(currentPlayerPlace);

        System.out.println(currentPlayerName
                + "'s new location is "
                + currentPlayerPlace);
        System.out.println("The category is " + currentCategory());
        questionManager.askQuestion(currentCategory());
    }
}
