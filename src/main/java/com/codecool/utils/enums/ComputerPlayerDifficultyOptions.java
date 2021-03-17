package com.codecool.utils.enums;

public enum ComputerPlayerDifficultyOptions {
    EASY("1 - Easy"), NORMAL("2 - Normal"), HARD("3 - Hard"), BACK("0 - Back to main menu");

    private final String option;

    ComputerPlayerDifficultyOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
