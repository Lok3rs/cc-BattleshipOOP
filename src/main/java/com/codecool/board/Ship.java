package com.codecool.board;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<Square> shipContent;
    private ShipOrientation shipOrientation;
    private int shipBowY;
    private int shipBowX;
    public final ShipType shipType;

    public Ship(ShipType shipType, ShipOrientation shipOrientation, int shipsBowY, int shipsBowX) {
        this.shipType = shipType;
        this.shipContent = new ArrayList<Square>();
        this.shipOrientation = shipOrientation;
        this.shipBowY = shipsBowY;
        this.shipBowX = shipsBowX;
        placeShip();
    }

    public void placeShip(){
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

    public void setShipOrientation(ShipOrientation shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public int getShipBowY() {
        return shipBowY;
    }

    public int getShipBowX() {
        return shipBowX;
    }

    public void setShipBowY(int Y) { this.shipBowY = Y;}

    public void setShipBowX(int X) { this.shipBowX = X;}
}
