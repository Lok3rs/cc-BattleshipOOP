package com.codecool.board.enums;

public enum Colors {
    YELLOW("\u001B[33m"), RED("\u001B[31m"), GREEN("\u001B[32m"), GRAY("\u001B[37m"), BLUE("\u001B[37m"), RESET("\u001B[0m ");

    private final String ANSICode;

    Colors(String ANSICode) {
        this.ANSICode = ANSICode;
    }

    public String getANSICode(){
        return this.ANSICode;
    }
}
