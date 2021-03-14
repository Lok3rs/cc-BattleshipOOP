package com.codecool.game;

import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;

import java.util.Arrays;

public class Game {
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void round(){

    }

    public boolean isGameOver(Square[][] gameBoard){
        for (Square[] row : gameBoard){
            if (Arrays.stream(row).map(Square::getSquareStatus).anyMatch(SquareStatus.SHIP::equals)) return false;
        }
        return true;
    }

}
