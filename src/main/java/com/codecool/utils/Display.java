package com.codecool.utils;

import java.util.List;

public class Display {

    public void printMenu() {
        printLogo();
        showMainMenuOptions();
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

    public void showHighscores(List<String> scores){
        int nameIndex = 0;
        int scoreIndex = 0;
        
    }
}
