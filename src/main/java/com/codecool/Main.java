package com.codecool;


import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.game.Battleship;
import com.codecool.game.Game;
import com.codecool.player.*;
import com.codecool.utils.Display;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //Battleship battleship = new Battleship();

        ///////////////////
        Player[] players = new Player[2];

        players[0] = new ComputerPlayerHard();
        players[1] = new ComputerPlayerHard();
        Player player1 = players[0];
        Player player2 = players[1];
        Game game = new Game(player1, player2);
        game.startGameRandomPlacement();
        //////////////////

    }
}
