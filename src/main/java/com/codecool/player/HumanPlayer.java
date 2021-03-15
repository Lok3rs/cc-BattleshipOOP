package com.codecool.player;

import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;

import java.util.List;

public class HumanPlayer extends Player {

    @Override
    public void handleShoot(Square[][] shootingBoard, Square[][] enemyBoard){
        display.clearScreen();
        display.showGameBoard(shootingBoard);
        display.printMessage(String.format("Shooting time! %s turn", this.name));
        int[] shootCoords = input.getCoordinates();
        int targetY = shootCoords[0];
        int targetX = shootCoords[1];
        while (shootingBoard[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY){
            display.printMessage("You have already shoot there.");
            shootCoords = input.getCoordinates();
            targetY = shootCoords[0];
            targetX = shootCoords[1];
        }
        switch (enemyBoard[targetY][targetX].getSquareStatus()) {
            case EMPTY -> {
                display.printMessage("You missed.");
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
            }
            case SHIP -> {
                display.printMessage("Hit!");
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
            }
        }
        display.clearScreen();
        display.showGameBoard(shootingBoard);
        input.waitForEnter();
    }
}

