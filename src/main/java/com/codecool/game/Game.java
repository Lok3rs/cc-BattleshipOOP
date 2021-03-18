package com.codecool.game;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.io.IOException;
import java.util.Arrays;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Display display = new Display();
    private final Input input = new Input();
    private final BoardFactory bf = new BoardFactory(display, input);

    private final Board player1Board = new Board();
    private final Board player1ShootingBoard = new Board();

    private final Board player2Board = new Board();
    private final Board player2ShootingBoard = new Board();

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGameManualPlacement() throws IOException {
        bf.randomPlacement(player1.getShipsCollection(), player1Board);
        bf.manualPlacement(player2.getShipsCollection(), player2Board);
        while (!isGameOver(player1Board.getGameBoard()) && !isGameOver(player2Board.getGameBoard())){
            round();
        }
        Player winner = getWinner();
        winner.increaseScore();
        display.printWinnerAsciiArt(winner);
        player1.saveScore();
        if (player2.getClass().equals(HumanPlayer.class)) player2.saveScore();
    }

    public void startGameRandomPlacement() throws IOException {
        bf.randomPlacement(player1.getShipsCollection(), player1Board);
        bf.randomPlacement(player2.getShipsCollection(), player2Board);
        while (!isGameOver(player1Board.getGameBoard()) && !isGameOver(player2Board.getGameBoard())){
            round();
        }
        Player winner = getWinner();
        winner.increaseScore();
        display.printWinnerAsciiArt(winner);
        player1.saveScore();
        if (player2.getClass().equals(HumanPlayer.class)) player2.saveScore();
    }

    public void round() throws IOException {
        player1.handleShoot(player1ShootingBoard, player2Board);
        player2.handleShoot(player2ShootingBoard, player1Board);
    }

    public boolean isGameOver(Square[][] gameBoard){
        for (Square[] row : gameBoard){
            if (Arrays.stream(row).map(Square::getSquareStatus).anyMatch(SquareStatus.SHIP::equals)) return false;
        }
        return true;
    }

    public Player getWinner(){
        if (isGameOver(player2Board.getGameBoard())) return player1;
        return player2;
    }
}
