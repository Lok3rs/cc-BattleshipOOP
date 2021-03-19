package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.utils.Input;

import java.io.IOException;
import java.util.ArrayList;

public class ComputerPlayerHard extends ComputerPlayer {
    int BOARD_SIZE = 10;
    private ArrayList<int[]> ShootStory = new ArrayList<int[]>();
    boolean checkAround = false;  //control when AI algorithm is used
    int[] checkAroundState = {0, 1, 2, 3, 4, 0};  //state of shoots directions: 0=random,1=-V,2=+V,3=-H,4=+H
    int checkState = checkAroundState[0]; //checkState - variable to control current algorithm stage
    int[] shootCoords;
    int[] firstHitCoords;  //variable used to keep 1st hit coords, important when algorithm changes a stage
    boolean firstRun = true;
    int computerHardShootIndex;
    private ArrayList<int[]> computerHardShootList = new ArrayList<int[]>();

    @Override
    public void handleShoot(Board boardShooting, Board boardEnemy) throws IOException {
        final Input input = new Input();

        if (!checkAround) {
            shootCoords = getCoordinatesAIhard();
        } else {
            shootCoords = getAroundCoords(shootCoords, checkState);
        }
        int targetY = shootCoords[0];
        int targetX = shootCoords[1];

        display.clearScreen();

        Square[][] shootingBoard = boardShooting.getGameBoard();
        Square[][] enemyBoard = boardEnemy.getGameBoard();

        //display.showGameBoard(enemyBoard);
       // display.showGameBoard(shootingBoard);
        display.printMessage(String.format("Shooting time! %s turn", this.name));
        //displayArray(ShootStory);

        while (shootingBoard[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY) {
            display.printMessage("You have already shoot there.");
            if (!checkAround) {
                shootCoords = getCoordinatesAIhard();
            } else {
                shootCoords = getAroundCoords(shootCoords, checkState = checkAroundState[checkState + 1]);
            }
            targetY = shootCoords[0];
            targetX = shootCoords[1];
        }
        ShootStory.add(shootCoords);
        switch (enemyBoard[targetY][targetX].getSquareStatus()) {
            case EMPTY -> {
                if (checkAround) {
                    checkState = checkAroundState[checkState + 1];
                    shootCoords = firstHitCoords;
                }
                if (checkAround && checkState == checkAroundState[5]) {
                    checkAround = false;
                    checkState = 0;
                }
                display.printMessage("Computer missed.");
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
                break;
            }
            case SHIP -> {
                checkAround = true;
                if (checkState == checkAroundState[0]) {
                    checkState = checkAroundState[1];
                    firstHitCoords = shootCoords;
                } //first shot on target
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                display.printMessage(boardEnemy.isShipSunk(targetY, targetX) ? "Hit and sunk!" : "Hit!");
                if (boardEnemy.isShipSunk(targetY, targetX)) {
                    boardEnemy.markSunk(shootingBoard, targetY, targetX);
                    checkAround = false;
                    checkState = checkAroundState[0];
                }
            }
        }
        display.clearScreen();
        display.showGameBoard(shootingBoard);
        input.waitForEnter();
    }

    public int[] getAroundCoords(int[] previous, int state) {
        //SWITCH to change state of shoots directions: 1=-V,2=+V,3=-H,4=+H,any=random
        do { //do while to make a correction(by continue) when current shoot out of board
            switch (state) {
                case 1 -> {
                    int[] nextCoords = {(previous[0] - 1), previous[1]};
                    if (nextCoords[0] < 0) {
                        previous = firstHitCoords;
                        state = 2;
                        checkState = state;
                    } else {
                        return nextCoords;
                    }
                    continue;
                }
                case 2 -> {
                    int[] nextCoords = {(previous[0] + 1), previous[1]};
                    if (nextCoords[0] >= BOARD_SIZE) {
                        previous = firstHitCoords;
                        state = 3;
                        checkState = state;
                    } else {
                        return nextCoords;
                    }
                    continue;
                }
                case 3 -> {
                    int[] nextCoords = {(previous[0]), (previous[1] - 1)};
                    if (nextCoords[1] < 0) {
                        previous = firstHitCoords;
                        state = 4;
                        checkState = state;
                    } else {
                        return nextCoords;
                    }
                    continue;
                }
                case 4 -> {
                    int[] nextCoords = {(previous[0]), previous[1] + 1};
                    if (nextCoords[1] >= BOARD_SIZE) {
                        previous = firstHitCoords;
                        state = 0;
                        checkState = state;
                    } else {
                        return nextCoords;
                    }
                    continue;
                }
                default -> {
                    int[] nextCoords = super.getRandomCoordinates();
                    return nextCoords;
                }
            }
        } while (true);
    }

    private void displayArray(ArrayList<int[]> Array) {
        System.out.println("Previous shoot: ");
        for (int[] col : Array) {
            for (int e : col) {
                System.out.print((e + 1) + ":");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }

    private int[] getCoordinatesAIhard(){
        if(firstRun) {
            firstRun = false;
            computerHardShootIndex=-1;
            createShootListAI3();
        }
        if(computerHardShootIndex < (computerHardShootList.size()-1)) {
            computerHardShootIndex+=1;
        } else {
            return super.getRandomCoordinates();
        }
        return computerHardShootList.get(computerHardShootIndex);
    }

    private void createShootListAI3(){
        //first diagonal L-R \
        for(int i=0;i<BOARD_SIZE;i++) {
            for(int j=0;j<BOARD_SIZE;j++) {
                if(i==j) {
                    computerHardShootList.add(new int[]{i, j});
                }
            }
        }
        //second diagonal R-L /
        for(int i=0;i<BOARD_SIZE;i++) {
            for(int j=0;j<BOARD_SIZE;j++) {
                if(j==BOARD_SIZE-1-i) {
                    computerHardShootList.add(new int[]{i, j});
                }
            }
        }
        //vertical center |
        for(int i=0;i<BOARD_SIZE;i++) {
            for(int j=0;j<BOARD_SIZE;j++) {
                if(j==(int)(BOARD_SIZE+1)/2) {
                    computerHardShootList.add(new int[]{i, j});
                }
            }
        }
        //horizontal center -
        for(int i=0;i<BOARD_SIZE;i++) {
            for(int j=0;j<BOARD_SIZE;j++) {
                if(i==(int)(BOARD_SIZE+1)/2) {
                    computerHardShootList.add(new int[]{i, j});
                }
            }
        }
        System.out.println("AI3 shoot list:");
        displayArray(computerHardShootList);
    }
}

//Description:
//1stage: shoot in diagonal line \ / and | - until hit a ship, when hit go to next stage:
//2stage: shots in -V direction until end of ship or game board
//3stage: shots in +V direction until end of ship or game board
//4stage: shots in -H direction until end of ship or game board
//5stage: shots in +H direction until end of ship or game board
//in any stage, when ship is sunk, algorithm goes back to stage1
//