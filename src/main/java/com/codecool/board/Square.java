package com.codecool.board;

public class Square {
    private final int X;
    private final int Y;
    private final SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus squareStatus) {
        this.X = x;
        this.Y = y;
        this.squareStatus = squareStatus;
    }

    public char getSquareCharacter(){
        return (char) squareStatus.getSquareUnicode();
    }
}
