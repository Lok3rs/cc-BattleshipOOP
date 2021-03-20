package com.codecool.game;

import com.codecool.highscores.Highscore;
import com.codecool.player.*;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.io.IOException;

public class Battleship {

    public Display display = new Display();
    public Input input = new Input(display);
    private final Highscore highscore = new Highscore(display);

    public void startGame() throws IOException {
        handleMainMenu();
    }

    private void start(Player player1, Player player2) throws IOException {
        display.clearScreen();
        Game game = new Game(player1, player2, display, input);
        game.startGame();
    }

    private void handleMainMenu() throws IOException {
        display.clearScreen();
        display.printLogo();
        display.showMainMenuOptions();
        switch (input.getOption(0, 2)) {
            case 1 -> handleGameMenu();
            case 2 -> {
                handleShowHighscores();
                handleMainMenu();
            }
            case 0 -> System.exit(0);
        }
    }

    private void handleShowHighscores() throws IOException {
        display.clearScreen();
        display.printLogo();
        display.showHighscores(highscore.getAllScores());
        input.waitForEnter();
    }

    private void handleGameMenu() throws IOException {
        display.clearScreen();
        display.printLogo();
        display.showStartGameOptions();
        switch (input.getOption(0, 3)) {
            case 1 -> {
                Player player1 = new HumanPlayer(display, input, highscore);
                Player player2 = new HumanPlayer(display, input, highscore);
                start(player1, player2);
            }
            case 2 -> handleComputerPlayerDifficultyMenu();
            case 3 -> handleComputerPlayersMenu();
            case 0 -> handleMainMenu();
        }
    }

    private void handleComputerPlayerDifficultyMenu() throws IOException {
        display.clearScreen();
        display.printLogo();
        Player player1 = null;
        Player player2 = null;
        display.showComputerPlayerDifficultyOptions();
        int option = input.getOption(0, 3);
        if (option != 0) player1 = new HumanPlayer(display, input, highscore);
        switch (option) {
            case 1 -> player2 = new ComputerPlayerEasy(display, input, highscore);
            case 2 -> player2 = new ComputerPlayerMedium(display, input, highscore);
            case 3 -> player2 = new ComputerPlayerHard(display, input, highscore);
            case 0 -> handleMainMenu();
        }
        if (option != 0) start(player1, player2);
    }

    private void handleComputerPlayersMenu() throws IOException {
        display.clearScreen();
        display.printLogo();
        display.showComputerPlayerDifficultyOptions();
        switch (input.getOption(0, 3)) {
            case 1 -> start(new ComputerPlayerEasy(display, input, highscore), new ComputerPlayerEasy(display, input, highscore));
            case 2 -> start(new ComputerPlayerMedium(display, input, highscore), new ComputerPlayerMedium(display, input, highscore));
            case 3 -> start(new ComputerPlayerHard(display, input, highscore), new ComputerPlayerHard(display, input, highscore));
            case 0 -> handleMainMenu();
        }
    }
}




