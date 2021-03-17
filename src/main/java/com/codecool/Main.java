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
//        Player newPlayer1 = new HumanPlayer();
//        Player newPlayer2 = new HumanPlayer();
//        Game newGame = new Game(newPlayer1, newPlayer2);
//        newGame.startGame();

        //Battleship battleship = new Battleship();

        /////////////////////   /////////////////////   /////////////////////   /////////////////////
//PvC
/*        Player newPlayer1 = new HumanPlayer();
        ComputerPlayer newPlayer2 = new ComputerPlayerMedium();
        Game newGame = new Game(newPlayer1, newPlayer2);
        newGame.startGame();*/

//CvC
        Player newPlayer1 = new ComputerPlayerEasy();
        ComputerPlayer newPlayer2 = new ComputerPlayerMedium();
        Game newGame = new Game(newPlayer1, newPlayer2);
        newGame.startGame();

    }
}
