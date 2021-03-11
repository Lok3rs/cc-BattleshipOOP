package com.codecool.player;

import com.codecool.board.Ship;
import com.codecool.board.ShipCollection;
import com.codecool.board.Square;
import com.codecool.utils.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int id;
    private String name;
    private int score;
    protected List<Ship> ships;
    protected boolean isAlive = true;
    private Input input = new Input();


    public Player(int id, String name, int score, List<Ship> ships, boolean isAlive){
        this.id = id;
        this.name = name;
        this.score = score;
        this.ships = ships;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
