package com.codecool;


import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.game.Battleship;
import com.codecool.game.Game;
import com.codecool.highscores.Highscore;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.utils.Display;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        Battleship battleship = new Battleship();
        Highscore highscore = new Highscore();
        highscore.createNewUser("Maciek", 100);

        highscore.closeConnection();
    }
}
