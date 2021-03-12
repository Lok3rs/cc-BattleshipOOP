package com.codecool.board;

import com.codecool.board.enums.ShipOrientation;
import com.codecool.board.enums.ShipType;
import com.codecool.board.enums.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<Square> shipContent;
    private final ShipOrientation shipOrientation;
    private final int shipBowY;
    private final int shipBowX;
    private final ShipType shipType;

    public Ship(ShipType shipType, ShipOrientation shipOrientation, int shipsBowY, int shipsBowX) {
        this.shipType = shipType;
        this.shipContent = new ArrayList<Square>();
        this.shipOrientation = shipOrientation;
        this.shipBowY = shipsBowY;
        this.shipBowX = shipsBowX;
        placeShip();
    }

    private void placeShip(){
        for (int i = 0; i < this.shipType.getShipLength(); i++){
            this.shipContent.add(
                    this.shipOrientation == ShipOrientation.HORIZONTAL ?
                            new Square(this.shipBowY, this.shipBowX + i, SquareStatus.SHIP) :
                            new Square(this.shipBowY + i, this.shipBowX, SquareStatus.SHIP)
            );
        }
    }

    public List<Square> getShipContent() {
        return shipContent;
    }

    public ShipOrientation getShipOrientation() {
        return shipOrientation;
    }

    public int getShipBowY() {
        return shipBowY;
    }

    public int getShipBowX() {
        return shipBowX;
    }
}
