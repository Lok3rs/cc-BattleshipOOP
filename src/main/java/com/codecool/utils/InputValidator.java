package com.codecool.utils;


public class InputValidator {

    private final int gameBoardSize = 10;

    public boolean isValidRowInput(String rowIdentifier) {
        return isValidOptionInput(rowIdentifier, 'A', 'A' + gameBoardSize) && rowIdentifier.length() == 1;
    }

    public boolean isValidColumnInput(String columnIdentifier) {
        return isValidOptionInput(columnIdentifier, 1, gameBoardSize) && columnIdentifier.length() == 1;
    }

    public boolean isValidOrientationIdentifier(String orientationIdentifier) {
        return isValidOptionInput(orientationIdentifier, 1, 2) && orientationIdentifier.length() == 1;
    }

    public boolean isValidOptionInput(String optionIdentifier, int minVal, int maxVal) {
        int optionId;
        try {
            optionId = Integer.parseInt(optionIdentifier);
            return optionId >= minVal && optionId <= maxVal;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
