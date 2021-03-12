package com.codecool.board;

import java.util.ArrayList;
import java.util.List;

public class ShipCollection {

    private final List<Ship> ships;

    public ShipCollection() {
        this.ships = new ArrayList<Ship>();
    }

    public void addShips(Ship ship) {
        ships.add(ship);
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }
}
