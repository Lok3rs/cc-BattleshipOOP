package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.enums.SquareStatus;
import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

public class ComputerPlayerEasy extends ComputerPlayer {

    public ComputerPlayerEasy(Display display, Input input, Highscore highscore) {
        super(display, input, highscore);
    }

    @Override
    protected void getCoordsAndShoot(Board shootingBoard, Board enemyBoard) {
        int targetY = getRandomCord();
        int targetX = getRandomCord();
        while (shootingBoard.getGameBoard()[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY) {
            targetY = getRandomCord();
            targetX = getRandomCord();
        }
        makeShot(enemyBoard, shootingBoard, targetY, targetX);
    }
}
