package com.codecool;


import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.game.Game;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.utils.Display;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Player newPlayer = new HumanPlayer();
        Player newPlayer2 = new HumanPlayer();
        Game newGame = new Game(newPlayer, newPlayer2);
        newGame.startGame();
    }
}
