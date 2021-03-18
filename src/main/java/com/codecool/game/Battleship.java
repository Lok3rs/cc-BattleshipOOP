package com.codecool.game;

import com.codecool.highscores.Highscore;
import com.codecool.player.*;
import com.codecool.utils.Display;
import com.codecool.utils.Input;
import java.io.IOException;

public class Battleship {

    public Input input = new Input();
    public Display display = new Display();
    private final Highscore highscore = new Highscore();

    public Battleship() throws IOException {
        display.printLogo();
        handleMainMenu();
    }

    public void prepareGame(Player[] players, String shipPlacement) throws IOException {
        Player player1 = players[0];
        Player player2 = players[1];
        Game game = new Game(player1, player2);

        if (shipPlacement == "manual") {
            game.startGameManualPlacement();
        } else {
            game.startGameRandomPlacement();
        }
    }

    public void handleMainMenu() throws IOException {
        display.showMainMenuOptions();
        int option = input.getOption();

        switch (option) {
            case 1:
                handleGameMenu();
                break;
            case 2:
                handleShowHighscores();
                handleMainMenu();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public void handleShowHighscores() throws IOException {
        display.showHighscores(highscore.getAllScores());
        input.waitForEnter();
    }

    public Player[] handleGameMenu() throws IOException {
        display.showStartGameOptions();
        int option = input.getOption();
        Player[] players = new Player[2];

        switch (option) {
            case 1:
                players[0] = new HumanPlayer();
                players[1] = new HumanPlayer();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 2:
                handleComputerPlayerDifficultyMenu();
                break;
            case 3:
                handleComputerPlayersMenu();
                break;
            case 0:
                handleMainMenu();
                break;
        }
        return players;
    }

    public Player[] handleComputerPlayerDifficultyMenu() throws IOException {
        display.showComputerPlayerDifficultyOptions();
        int option = input.getOption();
        Player[] players = new Player[2];

        switch (option) {
            case 1:
                players[0] = new HumanPlayer();
                players[1] = new ComputerPlayerEasy();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 2:
                players[0] = new HumanPlayer();
                players[1] = new ComputerPlayerMedium();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 3:
                players[0] = new HumanPlayer();
                players[1] = new ComputerPlayerHard();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 0:
                handleMainMenu();
                break;
        }
        return players;
    }

    public Player[] handleComputerPlayersMenu() throws IOException {
        //TODO: display.showComputerPlayerDifficultyOptions();
        System.out.println("Chose computers level");
        int option = input.getOption();
        Player[] players = new Player[2];

        switch (option) {
            case 1:
                players[0] = new ComputerPlayerEasy();
                players[1] = new ComputerPlayerEasy();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 2:
                players[0] = new ComputerPlayerEasy();
                players[1] = new ComputerPlayerMedium();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 3:
                players[0] = new ComputerPlayerEasy();
                players[1] = new ComputerPlayerHard();
                prepareGame(players, handleShipPlacementMenu());
                break;
            case 0:
                handleMainMenu();
                break;
        }
        return players;
    }

    public String handleShipPlacementMenu() throws IOException {
        display.showPlacementOptions();
        int option = input.getOption();
        String shipPlacement = "";

        switch (option) {
            case 1:
                shipPlacement = "manual";
                break;
            case 2:
                shipPlacement = "random";
                break;
            case 0:
                handleMainMenu();
                break;
        }
        return shipPlacement;
    }

}




