package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.utils.Input;

import java.io.IOException;
import java.util.ArrayList;

public class ComputerPlayerMedium extends ComputerPlayer {
    int BOARD_SIZE = 10;
    protected final String name="ComputerMedium";
    private ArrayList<int[]> ShootStory= new ArrayList<int[]>();
    boolean checkAround = false;  //control when AI algorithm is used
    int[] checkAroundState={0,1,2,3,4,0};  //state of shoots directions: 0=random,1=-V,2=+V,3=-H,4=+H
    int checkState=checkAroundState[0]; //checkState - variable to control current algorithm stage
    int[] shootCoords;
    int[] firstHitCoords;  //variable used to keep 1st hit coords, important when algorithm changes a stage

    @Override
    public void handleShoot(Board boardShooting, Board boardEnemy) throws IOException {
    final Input input = new Input();

    if(!checkAround) { shootCoords = super.getRandomCoordinates();
        System.out.println("FULL RANDOM1");} else { shootCoords = getAroundCoords(shootCoords,checkState);}
    int targetY = shootCoords[0];
    int targetX = shootCoords[1];

    //display.clearScreen();

    Square[][] shootingBoard = boardShooting.getGameBoard();
    Square[][] enemyBoard = boardEnemy.getGameBoard();

    //display.showGameBoard(enemyBoard);
   // display.showGameBoard(shootingBoard);
    System.out.println("POPRZEDNI STZRAL::::       "+checkAround+" |chAroundSTATE:: "+checkState);
    display.printMessage(String.format("Shooting time! %s turn", this.name));
    displayArray(ShootStory);
    System.out.println("NEXT==>:Random shoot: "+(shootCoords[0]+1)+"|"+(shootCoords[1]+1));

    while (shootingBoard[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY){
        display.printMessage("You have already shoot there.");
        if(!checkAround) { shootCoords = super.getRandomCoordinates();
            System.out.println("FULL RANDOM");} else { shootCoords = getAroundCoords(shootCoords,checkState=checkAroundState[checkState+1]);}
        targetY = shootCoords[0];
        targetX = shootCoords[1];
    }
    ShootStory.add(shootCoords);
    switch (enemyBoard[targetY][targetX].getSquareStatus()) {
        case EMPTY -> {
            System.out.println("checkAROUNDDDDD "+checkAround);
            if(checkAround) {checkState=checkAroundState[checkState+1];shootCoords= firstHitCoords;}
            if(checkAround && checkState==checkAroundState[5]){checkAround=false;checkState=0;}
            display.printMessage("Computer missed.");
            shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
            break;
        }
        case SHIP -> {
            checkAround=true;
            if(checkState==checkAroundState[0]) {checkState=checkAroundState[1];
                firstHitCoords =shootCoords;} //first shot on target
            shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
            enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
            display.printMessage(boardEnemy.isShipSunk(targetY, targetX) ? "Hit and sunk!" : "Hit!");
            if (boardEnemy.isShipSunk(targetY, targetX)){
                boardEnemy.markSunk(shootingBoard, targetY, targetX);
                checkAround=false;
                checkState=checkAroundState[0];
            }
        }
    }
    display.clearScreen();
    display.showGameBoard(shootingBoard);
    input.waitForEnter();
    }

    public int[] getAroundCoords(int[] previous, int state ) {
        //SWITCH to change state of shoots directions: 1=-V,2=+V,3=-H,4=+H,any=random
        System.out.println("OLD COORDS: "+(firstHitCoords[0]+1)+"|"+(firstHitCoords[1]+1));
        System.out.println("PREVIOUS==>: "+(previous[0]+1)+"|"+(previous[1]+1));
        do { //do while to make a correction(by continue) when current shoot out of board
            switch (state) {
                case 1 -> {
                    System.out.println("CASE -V: X" + (previous[1] + 1) + " Y" + (previous[0] + 1) + "=>" + previous[0]);
                    int[] nextCoords = {(previous[0] - 1), previous[1]};
                    if (nextCoords[0] < 0) { previous = firstHitCoords;
                        System.out.println("korekta -V na +V");state=2;checkState = state;} else { return nextCoords; }
                    continue;
                }
                case 2 -> {
                    System.out.println("CASE +V: X" + (previous[1] + 1) + " Y" + (previous[0] + 1) + "=>" + (previous[0] + 2));
                    int[] nextCoords = {(previous[0] + 1), previous[1]};
                    if (nextCoords[0] >= BOARD_SIZE) { previous = firstHitCoords;
                        System.out.println("korekta +V na -H");state=3;checkState = state;} else { return nextCoords; }
                    continue;
                }
                case 3 -> {
                    System.out.println("CASE -H: X" + (previous[1] + 1) + "=>" + (previous[0]) + " Y" + (previous[0] + 1));
                    int[] nextCoords = {(previous[0]), (previous[1] - 1)};
                    if (nextCoords[1] < 0) { previous = firstHitCoords;
                        System.out.println("korekta -H na +H");state=4;checkState = state;} else { return nextCoords; }
                    continue;
                }
                case 4 -> {
                    System.out.println("CASE +H: X" + (previous[1] + 1) + "=>" + (previous[0] + 2) + " Y" + (previous[0] + 1));
                    int[] nextCoords = {(previous[0]), previous[1] + 1};
                    if (nextCoords[1] >= BOARD_SIZE) { previous = firstHitCoords;
                        System.out.println("korekta +H na random");state=0;checkState = state;} else { return nextCoords; }
                    continue;
                }
                default -> {
                    System.out.println("CASE default");
                    System.out.println("FULL RANDOM2");
                    int[] nextCoords = super.getRandomCoordinates();
                    return nextCoords;
                }
            }
        } while (true);
    }

    private void displayArray(ArrayList<int[]> Array){
        System.out.println("Previous shoot: ");
        for(int[] col : Array) {
            for(int e : col) {
                System.out.print((e+1)+":");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }
}

//Description:
//1stage: random shots until hit a ship
//2stage: shots in -V direction until end of ship or game board
//3stage: shots in +V direction until end of ship or game board
//4stage: shots in -H direction until end of ship or game board
//5stage: shots in +H direction until end of ship or game board
//in any stage, when ship is sunk, algorithm goes back to stage1
//

