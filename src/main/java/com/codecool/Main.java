package com.codecool;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.board.ShipCollection;
import com.codecool.utils.Display;

public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        Board ocean = new Board();
        display.showGameBoard(ocean.getGameBoard());
        BoardFactory bf = new BoardFactory();
        ShipCollection ships = new ShipCollection();
        bf.randomPlacement(ships, ocean);
        display.showGameBoard(ocean.getGameBoard());
    }
}
