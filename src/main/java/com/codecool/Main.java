package com.codecool;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.board.ShipCollection;
import com.codecool.game.Game;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

public class Main {

    public static void main(String[] args) {
//        Display display = new Display();
//        Board ocean = new Board();
//        display.showGameBoard(ocean.getGameBoard());
//        Game newGame = new Game();
//        System.out.println(newGame.isGameOver(ocean.getGameBoard()));
//        BoardFactory bf = new BoardFactory();
//        ShipCollection ships = new ShipCollection();
//        bf.randomPlacement(ships, ocean);
//        display.showGameBoard(ocean.getGameBoard());
//        System.out.println(newGame.isGameOver(ocean.getGameBoard()));
        Input input = new Input();
        input.getCoordinates();

    }
}
