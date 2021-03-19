package com.codecool.utils;

import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.users.User;
import com.codecool.player.Player;
import com.codecool.utils.enums.ComputerPlayerDifficultyOptions;
import com.codecool.utils.enums.MainMenuOptions;
import com.codecool.utils.enums.ShipPlacementOptions;
import com.codecool.utils.enums.StartGameMenuOptions;

import java.util.List;

public class Display {
    private final String tabs = "\t\t\t\t\t\t";
    private final String borderLine = tabs + "============================";
    private final MainMenuOptions[] mainMenuOptions = MainMenuOptions.values();
    private final StartGameMenuOptions[] startGameMenuOptions = StartGameMenuOptions.values();
    private final ComputerPlayerDifficultyOptions[] computerPlayerDifficultyOptions = ComputerPlayerDifficultyOptions.values();
    private final ShipPlacementOptions[] shipPlacementOptions = ShipPlacementOptions.values();


    public void printMessage(String message){
        System.out.print(tabs + message);
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

    public void showPlacementOptions(){
        System.out.println(borderLine);
        System.out.printf(tabs + "|  %-24s|%n", "Choose placement method");
        for (ShipPlacementOptions option : shipPlacementOptions){
            System.out.printf(tabs + "|   %-23s|%n", option.getOption());
        }
        System.out.println(borderLine);
    }

    public void showHighscores(List<User> highscores){
        final String sepLine = tabs + "|--------------+-----------|";
        System.out.println(borderLine);
        System.out.printf(tabs + "|   %-10s |   %5s   |\n", "Name", "Score");
        if (highscores.size() > 0){
            System.out.println(sepLine);
            for (User user : highscores){
                System.out.printf(tabs + "|   %-10s |   %5s   |\n", user.getUsername(), user.getScore());
                if (highscores.indexOf(user) != highscores.size() - 1){
                    System.out.println(sepLine);
                }
            }
        }
        System.out.println(borderLine);
    }

    public void showGameBoard(Square[][] gameBoard){
        printColumnNumbers(gameBoard[0].length);
        for (int i = 0; i < gameBoard.length; i++){
            System.out.printf("%s%-2s", tabs, (char) (0x0041 + i));
            for (int j = 0; j < gameBoard[i].length; j++){
                System.out.print(gameBoard[i][j].getSquareStatus() == SquareStatus.SUNK ?
                       String.format("%2s",gameBoard[i][j].getSquareCharacter()):
                        String.format("%2s",gameBoard[i][j].getSquareCharacter()));
            }
            System.out.println();
        }
    }

    private void printColumnNumbers(int gameBoardLength){
        System.out.printf("%s ", tabs);
        for (int i = 0; i < gameBoardLength; i++){
            System.out.printf("%2s", (char) (0x24f5 + i));
        }
        System.out.println();
    }

    public void printWinnerAsciiArt(Player winner){
        System.out.println("""
                                              (_v_)                  \s
                                               _|_                   \s
                                               | |                   \s
                                          |-----+-----|          ,%%%.     \s
                                          |    1ST    |          % 1 %     \s
                                          |   PRIZE   |          `%%%'     \s
                                           '---------'            ( (      \s
                                            \\       /             )  )     \s
                                             '.   .'             (   (     \s
                                               | |                )'  )    \s
                                              .' '.              (/ \\/ \s
                                             _|___|_                 \s
                                            [#######]   \s
                """);
        System.out.printf("%s Winner is %s%n", tabs, winner.getName());
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
