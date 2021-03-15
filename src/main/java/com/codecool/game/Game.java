package com.codecool.game;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.utils.Display;

import java.util.Arrays;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Display display = new Display();
    private final BoardFactory bf = new BoardFactory();

    private final Board player1Board = new Board();
    private final Board player1ShootingBoard = new Board();

    private final Board player2Board = new Board();
    private final Board player2ShootingBoard = new Board();

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame(){
        bf.randomPlacement(player1.getShipsCollection(), player1Board);
        bf.randomPlacement(player2.getShipsCollection(), player2Board);
        while (true){
            PvPRound();
        }
    }

    public void PvPRound(){
        player1.handleShoot(player1ShootingBoard.getGameBoard(), player2Board.getGameBoard());
        player2.handleShoot(player2ShootingBoard.getGameBoard(), player1Board.getGameBoard());
    }

    public boolean isGameOver(Square[][] gameBoard){
        for (Square[] row : gameBoard){
            if (Arrays.stream(row).map(Square::getSquareStatus).anyMatch(SquareStatus.SHIP::equals)) return false;
        }
        return true;
    }

}
