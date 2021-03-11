package com.codecool.player;

import com.codecool.board.Ship;
import com.codecool.board.ShipCollection;
import com.codecool.board.Square;
import com.codecool.board.SquareStatus;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int id;
    private String name;
    private int score;
    protected boolean isAlive = true;
    protected ShipCollection ships;
    private Input input = new Input();
    private Display display = new Display();


    public Player(int id, String name, int score, boolean isAlive, ShipCollection ships){
        this.id = id;
        this.name = name;
        this.score = score;
        this.isAlive = isAlive;
        this.ships = ships;

    }


    private void handleShoot(Input input, ShipCollection ships) {
        List<Ship> shipsToCheck = ships.getShips();

        for (Ship ship : shipsToCheck) {
            for (Square square : ship.getShipContent()) {
                SquareStatus status = square.getSquareStatus();
                switch (status) {
                    case EMPTY:
                        System.out.println("you missed");
                        square.setSquareStatus(SquareStatus.MISSED);
                    case SHIP:
                        System.out.println("You hit a ship");
                        square.setSquareStatus(SquareStatus.HIT);
                    case HIT:
                        System.out.println("You already shoot here");
                    case MISSED:
                        System.out.println("You missed");
                        System.out.println("You already shoot here");
                }
            }
        }
    }

    private void checkIsAlive(ShipCollection ships){
        List<Ship> shipsToCheck = ships.getShips();
        int shipsCount = 0;

        for (Ship ship : shipsToCheck) {
            shipsCount++;
        }

        if (shipsCount == 0) {
            setAlive(false);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
