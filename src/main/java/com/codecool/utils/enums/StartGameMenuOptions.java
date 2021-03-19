package com.codecool.utils.enums;

public enum StartGameMenuOptions {
    PvP("1 - Player vs Player"), PvC("2 - Player vs Computer"), BACK("0 - Back to main menu");

    private final String option;

    StartGameMenuOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return this.option;
    }
}
