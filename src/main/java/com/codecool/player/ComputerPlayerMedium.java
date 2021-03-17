package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;
import com.codecool.utils.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ComputerPlayerMedium extends ComputerPlayer {
    protected final String name="ComputerMedium";
    private ArrayList<int[]> ShootStory= new ArrayList<int[]>();

    @Override
    public void handleShoot(Board boardShooting, Board boardEnemy) throws IOException {
    final Input input = new Input();
    int[] shootCoords;
    shootCoords = super.getRandomCoordinates();
    int targetY = shootCoords[0];
    int targetX = shootCoords[1];

    display.clearScreen();

    Square[][] shootingBoard = boardShooting.getGameBoard();
    Square[][] enemyBoard = boardEnemy.getGameBoard();

    display.showGameBoard(enemyBoard);
    display.showGameBoard(shootingBoard);
    display.printMessage(String.format("Shooting time! %s turn", this.name));
    displayArray(ShootStory);
    System.out.println("Random shoot: "+(shootCoords[0]+1)+"|"+(shootCoords[1]+1));

    while (shootingBoard[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY){
        display.printMessage("You have already shoot there.");
        shootCoords = super.getRandomCoordinates();
        targetY = shootCoords[0];
        targetX = shootCoords[1];
    }
    switch (enemyBoard[targetY][targetX].getSquareStatus()) {
        case EMPTY -> {
            display.printMessage("Computer missed.");
            shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
        }
        case SHIP -> {
            shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
            enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
            display.printMessage(boardEnemy.isShipSunk(targetY, targetX) ? "Hit and sunk!" : "Hit!");
            if (boardEnemy.isShipSunk(targetY, targetX)){
                boardEnemy.markSunk(shootingBoard, targetY, targetX);
            }
        }
    }
    ShootStory.add(shootCoords);
    display.clearScreen();
    display.showGameBoard(shootingBoard);
    input.waitForEnter();
    }

    private void displayArray(ArrayList<int[]> Array){
        System.out.println("Previous shoot: ");
        for(int[] col : Array) {
            for(int e : col) {
                System.out.print(e+":");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }
}
