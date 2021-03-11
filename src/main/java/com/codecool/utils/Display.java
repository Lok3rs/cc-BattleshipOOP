package com.codecool.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {

    public void printMenu() {
        printLogo();
        showMainMenuOptions();
        showStartGameOptions();
        List<List> scores = new ArrayList<>();
        scores.add(Arrays.asList("Bob", "100"));
        scores.add(Arrays.asList("John", "200"));
        scores.add(Arrays.asList("Emma", "300"));
        showHighscores(scores);
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

    public void showHighscores(List<List> scores){
        int nameIndex = 0;
        int scoreIndex = 0;
        String tabs = "\t\t\t\t\t\t";
        String sepLine = tabs + "|--------------+-----------|";
        System.out.println(tabs + "============================");
        System.out.printf(tabs + "|   %-10s |   %5s   |\n", "Name", "Score");
        if (scores.size() > 0){
            System.out.println(sepLine);
            for (List score : scores){
                System.out.printf(tabs + "|   %-10s |   %5s   |\n", score.get(0), score.get(1));
                if (scores.indexOf(score) != scores.size() - 1){
                    System.out.println(sepLine);
                }
            }
        }

        System.out.println(tabs + "============================");
    }
}
