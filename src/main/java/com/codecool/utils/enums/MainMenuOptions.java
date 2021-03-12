package com.codecool.utils.enums;

public enum MainMenuOptions{
    START("1 - Start new game"), HIGHSCORES("2 - Show highscores"), EXIT("0 - Exit");

    private final String option;

    MainMenuOptions(String option) {
        this.option = option;
    }

    public String getOption(){
        return this.option;
    }
}
