package com.codecool.board;

public class Square {
    private final int X;
    private final int Y;
    private final SquareStatus squareStatus;

    public Square(int y, int x, SquareStatus squareStatus) {
        this.Y = y;
        this.X = x;
        this.squareStatus = squareStatus;
    }

    public char getSquareCharacter(){
        return (char) squareStatus.getSquareUnicode();
    }
}
