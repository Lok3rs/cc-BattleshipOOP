package com.codecool.game;

import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;

import java.util.Arrays;

public class Game {


    public boolean isGameOver(Square[][] gameBoard){
        for (Square[] row : gameBoard){
            if (Arrays.stream(row).map(Square::getSquareStatus).anyMatch(SquareStatus.SHIP::equals)) return false;
        }
        return true;
    }
}
