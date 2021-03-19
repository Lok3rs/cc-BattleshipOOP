package com.codecool.board;

import com.codecool.board.enums.Colors;
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

    public String getSquareCharacter() {
        char squareSymbol = (char) squareStatus.getSquareUnicode();
        Colors color;
        switch (squareStatus) {
            case HIT -> color = Colors.YELLOW;
            case SUNK -> color = Colors.RED;
            case SHIP -> color = Colors.GREEN;
            case MISSED -> color = Colors.GRAY;
            default -> color = Colors.BLUE;
        }
        return String.format("%s%s%s", color.getANSICode(), squareSymbol, Colors.RESET.getANSICode());
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
