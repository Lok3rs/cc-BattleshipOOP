package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.io.IOException;
import java.util.ArrayList;

public class ComputerPlayerMedium extends ComputerPlayer {
    protected final int yIndex = 0;
    protected final int xIndex = 1;
    protected final int BOARD_SIZE = 10;
    protected final ArrayList<int[]> ShootStory = new ArrayList<>();
    protected boolean checkAround = false;  //control when AI algorithm is used
    protected int[] checkAroundState = {0, 1, 2, 3, 4, 0};  //state of shoots directions: 0=random,1=-V,2=+V,3=-H,4=+H
    protected int checkState = checkAroundState[0]; //checkState - variable to control current algorithm stage
    protected int[] shootCoords;
    protected int[] firstHitCoords;  //variable used to keep 1st hit coords, important when algorithm changes a stage

    public ComputerPlayerMedium(Display display, Input input, Highscore highscore) {
        super(display, input, highscore);
    }


    @Override
    protected void getCoordsAndShoot(Board shootingBoard, Board enemyBoard) {
        shootCoords = getShootCoords();
        int targetY = shootCoords[yIndex];
        int targetX = shootCoords[xIndex];
        while ((targetY > 9 || targetX > 9) && shootingBoard.getGameBoard()[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY) {
            if (!checkAround) {
                shootCoords = new int[]{getRandomCord(), getRandomCord()};
            } else {
                shootCoords = getAroundCoords(shootCoords, checkState = checkAroundState[checkState + 1]);
            }
            targetY = shootCoords[yIndex];
            targetX = shootCoords[xIndex];
        }
        ShootStory.add(shootCoords);
        makeShot(enemyBoard, shootingBoard, targetY, targetX);
    }

    @Override
    protected void makeShot(Board enemyBoard, Board shootingBoard, int targetY, int targetX) {
        switch (enemyBoard.getGameBoard()[targetY][targetX].getSquareStatus()) {
            case EMPTY -> {
                if (checkAround) {
                    checkState = checkAroundState[checkState + 1];
                    shootCoords = firstHitCoords;
                }
                if (checkAround && checkState == checkAroundState[5]) {
                    checkAround = false;
                    checkState = 0;
                }
                display.printMessage("Computer missed.\n");
                shootingBoard.getGameBoard()[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
            }
            case SHIP -> {
                checkAround = true;
                if (checkState == checkAroundState[yIndex]) {
                    checkState = checkAroundState[xIndex];
                    firstHitCoords = shootCoords;
                }
                shootingBoard.getGameBoard()[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                enemyBoard.getGameBoard()[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                display.printMessage(enemyBoard.isShipSunk(targetY, targetX) ? "Hit and sunk!\n" : "Hit!\n");
                if (enemyBoard.isShipSunk(targetY, targetX)) {
                    enemyBoard.markSunk(shootingBoard.getGameBoard(), targetY, targetX);
                    checkAround = false;
                    checkState = checkAroundState[0];
                }
            }
        }
    }

    protected int[] getShootCoords() {
        if (!checkAround) {
            shootCoords = new int[]{getRandomCord(), getRandomCord()};
        } else {
            shootCoords = getAroundCoords(shootCoords, checkState);
        }
        return shootCoords;
    }

    protected int[] getAroundCoords(int[] previous, int state) {
        do {
            switch (state) {
                case 1 -> {
                    int[] nextCoords = {(previous[yIndex] - 1), previous[xIndex]};
                    if (nextCoords[yIndex] < 0) {
                        previous = firstHitCoords;
                        checkState = 2;
                    } else {
                        return nextCoords;
                    }
                }
                case 2 -> {
                    int[] nextCoords = {(previous[yIndex] + 1), previous[xIndex]};
                    if (nextCoords[yIndex] >= BOARD_SIZE) {
                        previous = firstHitCoords;
                        checkState = 3;
                    } else {
                        return nextCoords;
                    }
                }
                case 3 -> {
                    int[] nextCoords = {(previous[xIndex]), (previous[xIndex] - 1)};
                    if (nextCoords[yIndex] < 0) {
                        previous = firstHitCoords;
                        checkState = 4;
                    } else {
                        return nextCoords;
                    }
                }
                case 4 -> {
                    int[] nextCoords = {(previous[yIndex]), previous[xIndex] + 1};
                    if (nextCoords[yIndex] >= BOARD_SIZE) {
                        previous = firstHitCoords;
                        checkState = 0;
                    } else {
                        return nextCoords;
                    }
                }
                default -> {
                    return new int[]{getRandomCord(), getRandomCord()};
                }
            }
        } while (true);
    }
}