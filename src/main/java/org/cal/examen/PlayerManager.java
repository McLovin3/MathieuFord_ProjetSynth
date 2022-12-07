package org.cal.examen;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private final List<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    private int currentPlayer = 0;

    public void addPlayer(String playerName) {
        players.add(playerName);
        int nbPlayers = players.size();

        places[nbPlayers] = 0;
        purses[nbPlayers] = 0;
        inPenaltyBox[nbPlayers] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + nbPlayers);
    }

    public void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public int getCurrentPlayerCoins() {
        return purses[currentPlayer];
    }

    public void removeCurrentPlayerFromPenaltyBox() {
        inPenaltyBox[currentPlayer] = false;
    }

    public void incrementCurrentPlayerCoins() {
        purses[currentPlayer]++;
    }

    public boolean hasCurrentPlayerWon() {
        return !(purses[currentPlayer] == 6);
    }

    public int getCurrentPlayerPlace() {
        return places[currentPlayer];
    }

    public void sendCurrentPlayerToPenaltyBox() {
        inPenaltyBox[currentPlayer] = true;
    }

    public void setCurrentPlayerPlace(int place) {
        places[currentPlayer] = place;
    }

    public String getCurrentPlayerName() {
        return players.get(currentPlayer);
    }

    public boolean isCurrentPlayerInPenaltyBox() {
        return inPenaltyBox[currentPlayer];
    }
}
