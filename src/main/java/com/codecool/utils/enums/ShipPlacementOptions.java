package com.codecool.utils.enums;

public enum ShipPlacementOptions {
    MANUAL("1 - Manual"), RANDOM("2 - Random"), BACK("0 - Back to main menu");

    private final String option;

    ShipPlacementOptions(String option) {
        this.option = option;
    }

    public String getOption(){
        return this.option;
    }
}
