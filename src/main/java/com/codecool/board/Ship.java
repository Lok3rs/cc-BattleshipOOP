package com.codecool.board;

import com.codecool.board.enums.ShipOrientation;
import com.codecool.board.enums.ShipType;
import com.codecool.board.enums.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<Square> shipContent;
    private final ShipType shipType;
    private ShipOrientation shipOrientation;
    private int shipBowY;
    private int shipBowX;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.shipContent = new ArrayList<>();
    }

    public void placeShip(Square[][] gameBoard){
        for (int i = 0; i < this.shipType.getShipLength(); i++){
            if (this.shipOrientation == ShipOrientation.HORIZONTAL) {
                gameBoard[this.shipBowY][this.shipBowX + i].setSquareStatus(SquareStatus.SHIP);
            } else {
                gameBoard[this.shipBowY + i][this.shipBowX ].setSquareStatus(SquareStatus.SHIP);
            }
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

    public void setShipOrientation(ShipOrientation shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public void setShipBowY(int shipBowY) {
        this.shipBowY = shipBowY;
    }

    public void setShipBowX(int shipBowX) {
        this.shipBowX = shipBowX;
    }

    public void setShipContent(){
        this.shipContent.clear();
        for (int i = 0; i < this.shipType.getShipLength(); i++){
        this.shipContent.add(
                this.shipOrientation == ShipOrientation.HORIZONTAL ?
                        new Square(this.shipBowY, this.shipBowX + i, SquareStatus.SHIP) :
                        new Square(this.shipBowY + i, this.shipBowX, SquareStatus.SHIP)
            );
        }
    }

    protected ShipType getShipType() {
        return this.shipType;
    }
}
