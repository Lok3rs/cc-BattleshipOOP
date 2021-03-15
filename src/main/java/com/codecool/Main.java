package com.codecool;


import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.player.HumanPlayer;
import com.codecool.utils.Display;

public class Main {

    public static void main(String[] args) {
        Display disp = new Display();

        BoardFactory bf = new BoardFactory();
        HumanPlayer player = new HumanPlayer();
        HumanPlayer player2 = new HumanPlayer();

        Board player1Board = new Board();
        bf.randomPlacement(player.getShipsCollection(), player1Board);
        Board player1ShootingBoard = new Board();

        Board player2Board = new Board();
        //bf.randomPlacement(player2.getShipsCollection(), player2Board);
        disp.showGameBoard(player2Board.getGameBoard());
        bf.manualPlacement(player2.getShipsCollection(), player2Board);
        Board player2ShootingBoard = new Board();

        disp.showGameBoard(player2Board.getGameBoard());
        player.handleShoot(player1ShootingBoard.getGameBoard(), player2Board.getGameBoard());



    }
}
