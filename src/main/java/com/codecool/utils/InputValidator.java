package com.codecool.utils;


public class InputValidator {

    private final int gameBoardSize = 10;

    public boolean isValidRowInput(String rowIdentifier) {
        int validRowInputLength = 1;
        boolean validRowLength = rowIdentifier.length() == validRowInputLength;
        if (!validRowLength) return false;
        int rowId = rowIdentifier.charAt(0);
        return rowId >= 'A' && rowId < 'A' + gameBoardSize;
    }

    public boolean isValidColumnInput(String columnIdentifier) {
        int columnId;
        try {
            columnId = Integer.parseInt(columnIdentifier);
        } catch (NumberFormatException e) {
            return true;
        }
        return columnId >= 1 && columnId <= gameBoardSize;
    }

    public boolean isValidOptionInput(String optionIdentifier) {
        int optionId;
        try {
            optionId = Integer.parseInt(optionIdentifier);
        } catch (NumberFormatException e) {
            return true;
        }
        return optionId >= 0 && optionId <= 3;
    }

    public boolean isValidOrientationIdentifier(String orientationIdentifier) {
        try {
            return Integer.parseInt(orientationIdentifier) == 1 || Integer.parseInt(orientationIdentifier) == 2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
