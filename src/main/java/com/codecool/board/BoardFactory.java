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
        display.printMessage("\nDefine position of your ships: ");
        int[] shootCoords;
        int counter=1;
        boolean firstTry;

        for(Ship ship: ships.getShips()) {
            firstTry=true;
            display.printMessage("Define ship with length: "+ship.getShipType().getShipLength());
            do {
                if(!firstTry) {display.printMessage("Wrong definition! Try again");}
                ship.setShipOrientation(input.setShipOrientation() == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL);
                shootCoords = input.getCoordinates();
                ship.setShipBowX(shootCoords[1]);
                ship.setShipBowY(shootCoords[0]);
                ship.setShipContent();
                firstTry=false;
            } while (!gameBoard.isPlacementOk(ship));
            display.printMessage("Defined ships: "+counter+"/5\n");
            counter++;
            ship.placeShip(gameBoard.getGameBoard());
            display.showGameBoard(gameBoard.getGameBoard());
        }
    }
}