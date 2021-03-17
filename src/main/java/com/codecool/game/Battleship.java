package com.codecool.game;

import com.codecool.player.*;
import com.codecool.utils.Display;
import com.codecool.utils.Input;
import java.io.IOException;

public class Battleship {

    public Input input = new Input();
    public Display display = new Display();

    public Battleship() throws IOException {
        handleMainMenu();
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
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public void handleShowHighscores(){

    }

    public void handleGameMenu() throws IOException {
        display.showStartGameOptions();
        int option = input.getOption();

        switch (option) {
            case 1:
                Player humanPlayer1 = new HumanPlayer();
                Player humanPlayer2 = new HumanPlayer();
                Game game = new Game(humanPlayer1, humanPlayer2);
                game.startGame();
//                handleShipPlacementMenu();
            case 2:
                handleComputerPlayerDifficultyMenu();
                break;
            case 0:
                handleMainMenu();
                break;
        }
    }

    public void handleComputerPlayerDifficultyMenu() throws IOException {
        display.showComputerPlayerDifficultyOptions();
        int option = input.getOption();
        Player humanPlayer = new HumanPlayer();

        switch (option) {
            case 1:
                Player computerPlayerEasy = new ComputerPlayerEasy();
//                handleShipPlacementMenu();
                break;
            case 2:
                Player computerPlayerMedium = new ComputerPlayerMedium();
//                handleShipPlacementMenu();
                break;
            case 3:
                Player computerPlayerHard = new ComputerPlayerHard();
//                handleShipPlacementMenu();
                break;
            case 0:
                handleGameMenu();
                break;
        }

    }

//    public void handleShipPlacementMenu() {
//        display.showPlacementOptions();
//        int option = input.getOption();
//
//        switch (option) {
//            case 1: Game newGame = new Game();
//        }
//    }

}




