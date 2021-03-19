package com.codecool.board;

import com.codecool.board.enums.ShipType;

import java.util.ArrayList;
import java.util.List;

public class ShipCollection {

    private final List<Ship> ships = new ArrayList<>();

    public ShipCollection() {
        for (ShipType shipType : ShipType.values()){
            addShips(new Ship(shipType));
        }
    }

    public void addShips(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }
}
