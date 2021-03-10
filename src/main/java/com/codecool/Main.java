package com.codecool;

import com.codecool.board.ShipType;
import com.codecool.board.Square;
import com.codecool.board.SquareStatus;

public class Main {

    public static void main(String[] args) {
        ShipType shipType = ShipType.Carrier;
        System.out.println(shipType.getShipLength());
    }
}
