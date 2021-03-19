package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.enums.SquareStatus;
import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;


public class HumanPlayer extends Player {

    public HumanPlayer(Display display, Input input, Highscore highscore) {
        super(display, input, highscore);
    }

    @Override
    protected void getCoordsAndShoot(Board shootingBoard, Board enemyBoard) {
        int[] shootCoords = input.getCoordinates();
        int targetY = shootCoords[0];
        int targetX = shootCoords[1];
        while (shootingBoard.getGameBoard()[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY) {
            display.printMessage("You have already shoot there.");
            shootCoords = input.getCoordinates();
            targetY = shootCoords[0];
            targetX = shootCoords[1];
        }
        makeShot(enemyBoard, shootingBoard, targetY, targetX);
    }
}

