package com.codecool.board.enums;

public enum ShipType {
    //Carrier(5), Cruiser(4), Battleship(3), Submarine(2), Destroyer(1);
    //Carrier(3), Cruiser(3), Battleship(3), Submarine(3), Destroyer(3), Carrier2(3), Cruiser2(3), Battleship2(3), Submarine2(3), Destroyer2(3);
    Carrier(8), Cruiser(8), Battleship(8), Submarine(3);

    private final int shipLength;

    ShipType(int shipLength) {
        this.shipLength = shipLength;
    }

    public int getShipLength(){
        return this.shipLength;
    }
}
