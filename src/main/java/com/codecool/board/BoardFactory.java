package com.codecool.board;

import com.codecool.board.enums.ShipOrientation;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.util.List;
import java.util.Random;

public class BoardFactory {
    private final Random random = new Random();

    private final Display display;
    private final Input input;

    public BoardFactory(Display display, Input input){
        this.display = display;
        this.input = input;
    }

    public void randomPlacement(ShipCollection ships, Board gameBoard) {
        for (Ship ship : ships.getShips()) {
            do {
                ship.setShipOrientation(random.nextInt(2) == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL);
                ship.setShipBowX(random.nextInt(10));
                ship.setShipBowY(random.nextInt(10));
                ship.setShipContent();
            } while (!gameBoard.isPlacementOk(ship));
            ship.placeShip(gameBoard.getGameBoard());
        }
    }

    public void manualPlacement(ShipCollection shipsCollection, Board gameBoard) {
        final int yIndex = 0;
        final int xIndex = 1;
        int[] placementCoords;
        boolean firstTry = true;
        List<Ship> ships = shipsCollection.getShips();
        for (Ship ship : ships) {
            display.printMessage(String.format("Defined ships: %d/5", ships.indexOf(ship)));
            display.showGameBoard(gameBoard.getGameBoard());
            display.printMessage("Define ship with length: " + ship.getShipType().getShipLength());
            do {
                if (!firstTry) display.printMessage("Wrong definition! Try again");
                ship.setShipOrientation(input.setShipOrientation() == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL);
                placementCoords = input.getCoordinates();
                ship.setShipBowX(placementCoords[xIndex]);
                ship.setShipBowY(placementCoords[yIndex]);
                ship.setShipContent();
                firstTry = false;
            } while (!gameBoard.isPlacementOk(ship));
            ship.placeShip(gameBoard.getGameBoard());
        }
    }
}