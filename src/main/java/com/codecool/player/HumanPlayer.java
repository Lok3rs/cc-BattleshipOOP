package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;

import java.io.IOException;
import java.util.List;

public class HumanPlayer extends Player {

    @Override
    public void handleShoot(Board boardShooting, Board boardEnemy) throws IOException {
        Square[][] shootingBoard = boardShooting.getGameBoard();
        Square[][] enemyBoard = boardEnemy.getGameBoard();
        display.clearScreen();
        display.showGameBoard(enemyBoard);
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
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                display.printMessage(boardEnemy.isShipSunk(targetY, targetX) ? "Hit and sunk!" : "Hit!");
                this.score += 2;
                if (boardEnemy.isShipSunk(targetY, targetX)){
//                    shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.SUNK);
//                    enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.SUNK);
                    boardEnemy.markSunk(shootingBoard, targetY, targetX);
                    this.score += 10;
                }
            }
        }
        display.clearScreen();
        display.showGameBoard(shootingBoard);
        display.printMessage(String.format("Your current score is: %d", getScore()));
        input.waitForEnter();
    }
}

