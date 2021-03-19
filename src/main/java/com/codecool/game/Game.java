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
    private final Display display;
    private final BoardFactory bf;

    private final Board player1Board = new Board();
    private final Board player1ShootingBoard = new Board();

    private final Board player2Board = new Board();
    private final Board player2ShootingBoard = new Board();

    public Game(Player player1, Player player2, Display display, Input input) {
        this.player1 = player1;
        this.player2 = player2;
        this.display = display;
        this.bf = new BoardFactory(display, input);
    }

    public void startGame() throws IOException {
        bf.chosePlacement(player1.getShipsCollection(), player1Board, player1.getName());
        bf.chosePlacement(player2.getShipsCollection(), player2Board, player2.getName());
        while (!isGameOver(player1Board.getGameBoard()) && !isGameOver(player2Board.getGameBoard())) {
            round();
        }
        Player winner = getWinner();
        winner.increaseScore();
        display.printWinnerAsciiArt(winner);
        if (player1.getClass().equals(HumanPlayer.class)) player1.saveScore();
        if (player2.getClass().equals(HumanPlayer.class)) player2.saveScore();
    }

    private void round() throws IOException {
        player1.handleShoot(player1ShootingBoard, player2Board);
        player2.handleShoot(player2ShootingBoard, player1Board);
    }

    private boolean isGameOver(Square[][] gameBoard) {
        for (Square[] row : gameBoard) {
            if (Arrays.stream(row).map(Square::getSquareStatus).anyMatch(SquareStatus.SHIP::equals)) return false;
        }
        return true;
    }

    private Player getWinner() {
        if (isGameOver(player2Board.getGameBoard())) return player1;
        return player2;
    }
}
