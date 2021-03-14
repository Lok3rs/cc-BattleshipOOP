package com.codecool.board;

import com.codecool.board.enums.ShipOrientation;

import java.util.Random;

public class BoardFactory {

    private final Random random = new Random();

    public void randomPlacement(ShipCollection ships, Board gameBoard) {
        for(Ship ship: ships.getShips()) {
            do {
                ship.setShipOrientation(random.nextInt(2) == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL);
                ship.setShipBowX(random.nextInt(10));
                ship.setShipBowY(random.nextInt(10));
                ship.setShipContent();
            } while (!gameBoard.isPlacementOk(ship));
            ship.placeShip(gameBoard.getGameBoard());
        }
    }
}