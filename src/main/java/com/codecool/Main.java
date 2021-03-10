package com.codecool;

import com.codecool.board.SquareStatus;

public class Main {

    public static void main(String[] args) {
        SquareStatus squareStatus = SquareStatus.SHIP;
        System.out.println(squareStatus.getSquareCharacter());
    }
}
