package com.codecool.board;

public enum SquareStatus {

    EMPTY(0), SHIP(1), HIT(2), MISSED(3);

    private final int squareStatusCode;

    SquareStatus(int squareStatusCode) {
        this.squareStatusCode = squareStatusCode;
    }

    public char getSquareCharacter(){
        switch (this.squareStatusCode){
            case 0 -> {
                return (char) 0x25A1;
            }
            case 1 -> {
                return (char) 0x25A9;
            }
            case 2 -> {
                return (char) 0x25A3;
            }
            case 3 -> {
                return (char) 0x25A0;
            }
            default -> {
                return (char) 0x25CB;
            }
        }
    }

}
