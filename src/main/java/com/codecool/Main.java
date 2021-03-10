package com.codecool;

import com.codecool.board.Square;
import com.codecool.board.SquareStatus;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(10, 10, SquareStatus.MISSED);
        System.out.println(square.getSquareCharacter());
    }
}
