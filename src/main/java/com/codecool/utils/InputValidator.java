package com.codecool.utils;


public class InputValidator {

    private final int gameBoardSize = 10;

    public boolean isValidRowInput(String rowIdentifier){
        int validRowInputLength = 1;
        boolean validRowLength = rowIdentifier.length() == validRowInputLength;
        if (!validRowLength) return false;
        int rowId = rowIdentifier.charAt(0);
        return rowId >= 'A' && rowId < 'A' + gameBoardSize;
    }

    public boolean isValidColumnInput(String columnIdentifier){
        int columnId;
        try {
            columnId = Integer.parseInt(columnIdentifier);
        }
        catch(NumberFormatException e){
            return true;
        }
        return columnId >= 1 && columnId <= gameBoardSize;
    }
}