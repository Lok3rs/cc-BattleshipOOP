package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Square;
import com.codecool.board.enums.SquareStatus;

import java.io.IOException;

public class ComputerPlayerEasy extends ComputerPlayer {

    @Override
    public void handleShoot(Board boardShooting, Board boardEnemy) throws IOException {
        Square[][] shootingBoard = boardShooting.getGameBoard();
        Square[][] enemyBoard = boardEnemy.getGameBoard();
        display.clearScreen();
        display.showGameBoard(enemyBoard);
        display.showGameBoard(shootingBoard);
        display.printMessage(String.format("Shooting time! %s turn", this.name));
        int targetY = getRandomNumber();
        int targetX = getRandomNumber();
        while (shootingBoard[targetY][targetX].getSquareStatus() != SquareStatus.EMPTY){
            targetY = getRandomNumber();
            targetX = getRandomNumber();
        }
        switch (enemyBoard[targetY][targetX].getSquareStatus()) {
            case EMPTY -> {
                display.printMessage(this.name + " missed.");
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
            }
            case SHIP -> {
                shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                display.printMessage(boardEnemy.isShipSunk(targetY, targetX) ? "Hit and sunk!" : "Hit!");
                if (boardEnemy.isShipSunk(targetY, targetX)){
//                    shootingBoard[targetY][targetX].setSquareStatus(SquareStatus.SUNK);
//                    enemyBoard[targetY][targetX].setSquareStatus(SquareStatus.SUNK);
                    boardEnemy.markSunk(shootingBoard, targetY, targetX);
                }
            }
        }
        display.clearScreen();
        display.showGameBoard(shootingBoard);
        input.waitForEnter();
    }
}
