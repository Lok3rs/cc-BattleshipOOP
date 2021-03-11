package com.codecool.utils;

import com.codecool.board.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Display {

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
        System.out.println("""
                                        ============================
                                        |        Main menu         |
                                        |    1 - Start new game    |
                                        |    2 - Show highscores   |
                                        |    0 - Exit              |
                                        ============================
                """);
    }

    public void showStartGameOptions(){
        System.out.println("""
                                        ============================
                                        |    Choose game option    |
                                        |   1 - Player vs Player   |
                                        |   2 - Player vs Computer | 
                                        |   0 - Back to main menu  |
                                        ============================
                """);
    }

    public void showComputerPlayerDifficultyOptions(){
        System.out.println("""
                                        ============================
                                        | Choose difficulty level  |
                                        |        1 - Easy          |
                                        |        2 - Medium        | 
                                        |        2 - Hard          | 
                                        |        0 - Back          |
                                        ============================
                """);
    }

    public void showHighscores(List<List> scores){
        final int nameIndex = 0;
        final int scoreIndex = 1;
        final String tabs = "\t\t\t\t\t\t";
        final String sepLine = tabs + "|--------------+-----------|";
        final String borderLine = tabs + "============================";
        System.out.println(borderLine);
        System.out.printf(tabs + "|   %-10s |   %5s   |\n", "Name", "Score");
        if (scores.size() > 0){
            System.out.println(sepLine);
            for (List score : scores){
                System.out.printf(tabs + "|   %-10s |   %5s   |\n", score.get(nameIndex), score.get(scoreIndex));
                if (scores.indexOf(score) != scores.size() - 1){
                    System.out.println(sepLine);
                }
            }
        }
        System.out.println(borderLine);
    }

    public void showGameBoard(Square[][] gameBoard){
        final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWYZ".toCharArray();
        printColumnNumbers(gameBoard.length);
        for (int i = 0; i < gameBoard.length; i++){

        }

    }

    private void printColumnNumbers(int gameBoardLength){
        for (int i = 0; i < gameBoardLength; i++){
            int mod = i == 0 ? 5 : 4;
            System.out.printf("%" + mod + "s", i + 1);
        }
        System.out.print("\n");
    }
}
