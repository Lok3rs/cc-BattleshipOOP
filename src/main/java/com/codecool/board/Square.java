package com.codecool.board;

import com.codecool.board.enums.SquareStatus;

public class Square {
    private final int X;
    private final int Y;
    private SquareStatus squareStatus;

    public Square(int y, int x, SquareStatus squareStatus) {
        this.Y = y;
        this.X = x;
        this.squareStatus = squareStatus;
    }

    public char getSquareCharacter(){
        return (char) squareStatus.getSquareUnicode();
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
