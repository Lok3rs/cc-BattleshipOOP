package com.codecool.board;

import java.util.ArrayList;
import java.util.List;

public class ShipCollection {

    //10x
    //1s-4, 2s-3,3s-2,4s-1

    private final List<Ship> ships;

    public ShipCollection() {
        this.ships = new ArrayList<Ship>();
    }

    public void addShips(Ship ship) {
        ships.add(ship);
    }

    public void  removeShip(Ship ship) {
        ships.remove(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }
}
