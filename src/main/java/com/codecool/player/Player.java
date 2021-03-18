package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Ship;
import com.codecool.board.ShipCollection;
import com.codecool.board.Square;
import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.io.IOException;

public abstract class Player {

    protected final String name;
    protected ShipCollection ships = new ShipCollection();
    protected int score = 0;
    protected Input input = new Input();
    protected Display display = new Display();
    protected final Highscore highscore = new Highscore();

    public Player() {
        this.name = input.getPlayerName();
    }

    public void removeShip(Ship ship){
        ships.removeShip(ship);
    }

    public boolean isAlive(){
        return ships.getShips().size() > 0;
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

    public void handleShoot(Board boardShooting, Board boardEnemy) throws IOException {

    }

    public void saveScore(){
        if (highscore.findUser(this.name)) {
            highscore.updateScore(this.name, this.score);
        } else {
            highscore.createNewUser(this.name, this.score);
        }
    }

}
