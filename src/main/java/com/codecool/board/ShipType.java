package com.codecool.board;

public enum ShipType {
    Carrier(5), Cruiser(4), Battleship(3), Submarine(2), Destroyer(1);

    private final int shipLength;

    ShipType(int shipLength) {
        this.shipLength = shipLength;
    }

    public int getShipLength(){
        return this.shipLength;
    }
}
