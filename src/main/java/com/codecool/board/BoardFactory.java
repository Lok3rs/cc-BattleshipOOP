package com.codecool.board;

import com.codecool.board.enums.ShipOrientation;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.util.Random;

public class BoardFactory {

    private final Random random = new Random();
    private final Display display = new Display();
    private final Input input = new Input();

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

    public void manualPlacement(ShipCollection ships, Board gameBoard) {
        display.printMessage("Define position of your ships: ");
        int[] shootCoords;

        int counter=1;

        for(Ship ship: ships.getShips()) {
            System.out.println("Defined ships with length: "+ship.getShipType());
            do {
                ship.setShipOrientation(input.setShipOrientation() == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL);
                shootCoords = input.getCoordinates();
                ship.setShipBowX(shootCoords[0]);
                ship.setShipBowY(shootCoords[1]);
                ship.setShipContent();
            } while (!gameBoard.isPlacementOk(ship));
            System.out.println("Defined ships: "+counter+"/5\n");
            counter++;
            ship.placeShip(gameBoard.getGameBoard());
        }
    }
}