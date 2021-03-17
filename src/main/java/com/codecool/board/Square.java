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

    public String getSquareCharacter(){
        char squareSymbol = (char) squareStatus.getSquareUnicode();
        String returnableString;
        switch (squareStatus){
            case HIT -> {
                returnableString = String.format("\u001B[33m%s\u001B[0m ", squareSymbol);
            }
            case SUNK -> {
                returnableString = String.format("\u001B[31m%s\u001B[0m ", squareSymbol);
            }
            case SHIP -> {
                returnableString = String.format("\u001B[32m%s\u001B[0m ", squareSymbol);
            }
            case MISSED -> {
                returnableString = String.format("\u001B[37m%s\u001B[0m ", squareSymbol);
            }
            default -> {
                returnableString = String.format("\u001B[34m%s\u001B[0m ", squareSymbol);
            }
        }
        return returnableString;
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
