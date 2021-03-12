package com.codecool.utils;

import com.codecool.board.Square;
import com.codecool.board.SquareStatus;
import com.codecool.utils.enums.ComputerPlayerDifficultyOptions;
import com.codecool.utils.enums.MainMenuOptions;
import com.codecool.utils.enums.StartGameMenuOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {
    private final String tabs = "\t\t\t\t\t\t";
    private final String borderLine = tabs + "============================";
    private final MainMenuOptions[] mainMenuOptions = MainMenuOptions.values();
    private final StartGameMenuOptions[] startGameMenuOptions = StartGameMenuOptions.values();
    private final ComputerPlayerDifficultyOptions[] computerPlayerDifficultyOptions = ComputerPlayerDifficultyOptions.values();

    public void printMenu() {
        printLogo();
        showMainMenuOptions();
        showStartGameOptions();
        showComputerPlayerDifficultyOptions();
        List<List> scores = new ArrayList<>();
        scores.add(Arrays.asList("Bob", "100"));
        scores.add(Arrays.asList("John", "200"));
        scores.add(Arrays.asList("Emma", "300"));
        showHighscores(scores);
        showGameBoard(new Square[][]{
                {new Square(1, 1, SquareStatus.MISSED),new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.EMPTY),new Square(1, 1, SquareStatus.SHIP), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.EMPTY),new Square(1, 1, SquareStatus.MISSED), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.EMPTY),new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.MISSED), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.MISSED),new Square(1, 1, SquareStatus.MISSED), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.HIT),new Square(1, 1, SquareStatus.MISSED), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.EMPTY),new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.EMPTY),new Square(1, 1, SquareStatus.EMPTY), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.HIT),new Square(1, 1, SquareStatus.EMPTY), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
                {new Square(1, 1, SquareStatus.HIT),new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT), new Square(1, 1, SquareStatus.HIT)},
        });

    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printLogo(){
        System.out.println("""
                                                     |__
                                                     |\\/
                                                     ---
                                                     / | [
                                              !      | |||
                                            _/|     _/|-++'
                                        +  +--|    |--|--|_ |-
                                     { /|__|  |/\\__|  |--- |||__/
                                    +---------------___[}-_===_.'____                 /\\
                                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _
                 __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7
                |                                                                     BB-61/
                 \\_________________________________________________________________________|
                                 _           _   _   _           _     _      \s
                                | |         | | | | | |         | |   (_)     \s
                                | |__   __ _| |_| |_| | ___  ___| |__  _ _ __ \s
                                | '_ \\ / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\\s
                                | |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |
                                |_.__/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/\s
                                                                        | |   \s
                                                                        |_|  \s
                """);
    }

    public void showMainMenuOptions(){
        System.out.println(borderLine);
        System.out.printf(tabs + "|         %-17s|%n", "Main Menu");
        for (MainMenuOptions option : mainMenuOptions){
            System.out.printf(tabs + "|    %-22s|%n", option.getOption());
        }
        System.out.println(borderLine);
    }


    public void showStartGameOptions(){
        System.out.println(borderLine);
        System.out.printf(tabs + "|    %-22s|%n", "Choose game option");
        for (StartGameMenuOptions option : startGameMenuOptions){
            System.out.printf(tabs + "|   %-23s|%n", option.getOption());
        }
        System.out.println(borderLine);
    }

    public void showComputerPlayerDifficultyOptions(){
        System.out.println(borderLine);
        System.out.printf(tabs + "|  %-24s|%n", "Choose difficulty level");
        for (ComputerPlayerDifficultyOptions option : computerPlayerDifficultyOptions){
            System.out.printf(tabs + "|        %-18s|%n", option.getOption());
        }
        System.out.println(borderLine);
    }

    public void showHighscores(List<List> scores){
        final int nameIndex = 0;
        final int scoreIndex = 1;
        final String sepLine = tabs + "|--------------+-----------|";
        System.out.println(borderLine);
        System.out.printf(tabs + "|   %-10s |   %5s   |\n", "Name", "Score");
        if (scores.size() > 0){
            System.out.println(sepLine);
            for (var score : scores){
                System.out.printf(tabs + "|   %-10s |   %5s   |\n", score.get(nameIndex), score.get(scoreIndex));
                if (scores.indexOf(score) != scores.size() - 1){
                    System.out.println(sepLine);
                }
            }
        }
        System.out.println(borderLine);
    }

    public void showGameBoard(Square[][] gameBoard){
        printColumnNumbers(gameBoard[0].length);
        for (int i = 0; i < gameBoard.length; i++){
            System.out.printf("%-1s",(char) (0x24b6 + i));
            for (int j = 0; j < gameBoard[i].length; j++){
                System.out.format("%3s",gameBoard[i][j].getSquareCharacter());
            }
            System.out.println();
        }
    }

    private void printColumnNumbers(int gameBoardLength){
        System.out.print(" ");
        for (int i = 0; i < gameBoardLength; i++){
            System.out.printf("%3s", (char) (0x24f5 + i));
        }
        System.out.println();
    }
}
