package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.ShipCollection;
import com.codecool.board.enums.SquareStatus;
import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.io.IOException;

public abstract class Player {

    protected final String name;
    protected ShipCollection ships = new ShipCollection();
    protected int score = 0;
    protected final Input input;
    protected final Display display;
    protected final Highscore highscore;

    public Player(Display display, Input input, Highscore highscore) {
        this.name = input.getPlayerName();
        this.display = display;
        this.input = input;
        this.highscore = highscore;
    }



    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void increaseScore(){
        this.score += 30;
    }

    public ShipCollection getShipsCollection(){
        return ships;
    }

    public void handleShoot(Board shootingBoard, Board enemyBoard) throws IOException {
        display.clearScreen();
        display.showGameBoard(enemyBoard.getGameBoard()); // for training purposes
        display.showGameBoard(shootingBoard.getGameBoard());
        display.printMessage(String.format("Shooting time! %s's turn\n", this.name));

        getCoordsAndShoot(shootingBoard, enemyBoard);

        display.clearScreen();
        display.showGameBoard(shootingBoard.getGameBoard());
        display.printMessage(String.format("%ss' current score is: %d\n", this.name, getScore()));
        input.waitForEnter();
    }

    public void saveScore(){
        if (highscore.findUser(this.name)) {
            highscore.updateScore(this.name, this.score);
        } else {
            highscore.createNewUser(this.name, this.score);
        }
    }

    protected void makeShot(Board enemyBoard, Board shootingBoard, int targetY, int targetX){
        switch (enemyBoard.getGameBoard()[targetY][targetX].getSquareStatus()) {
            case EMPTY -> {
                display.printMessage(this.getClass() == HumanPlayer.class ? "You missed." : "Computer missed.");
                shootingBoard.getGameBoard()[targetY][targetX].setSquareStatus(SquareStatus.MISSED);
            }
            case SHIP -> {
                shootingBoard.getGameBoard()[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                enemyBoard.getGameBoard()[targetY][targetX].setSquareStatus(SquareStatus.HIT);
                display.printMessage(enemyBoard.isShipSunk(targetY, targetX) ? "Hit and sunk!" : "Hit!");
                this.score += 2;
                if (enemyBoard.isShipSunk(targetY, targetX)) {
                    enemyBoard.markSunk(shootingBoard.getGameBoard(), targetY, targetX);
                    this.score += 10;
                }
            }
        }
    }

    protected void getCoordsAndShoot(Board shootingBoard, Board enemyBoard){

    }

}
