package com.codecool.utils;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);
    private final Display display = new Display();
    private final InputValidator inputValidator = new InputValidator();


    public int[] getCoordinates(){
        return new int[]{getRowIndex(), getColumnIndex()};
    }

    private int getRowIndex(){
        int letterAUnicodeDistanceFrom0 = 65;
        boolean firstTry = true;
        String userInput = "";
        do{
            display.printMessage(firstTry ? "Provide row index: " : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next().toUpperCase();
        } while (!inputValidator.isValidRowInput(userInput));
        return userInput.charAt(0) - letterAUnicodeDistanceFrom0;
    }

    private int getColumnIndex(){
        boolean firstTry = true;
        String userInput = "";
        do{
            display.printMessage(firstTry ? "Provide column index: " : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next().toUpperCase();
        } while (!inputValidator.isValidColumnInput(userInput));
        return Integer.parseInt(userInput) - 1;
    }

    public String getPlayerName(){
        display.printMessage("Provide a player name: ");
        return scanner.next();
    }

    public int setShipOrientation(){
        boolean firstTry = true;
        String userInput = "";
        do{
            display.printMessage(firstTry ? "Provide a ship orientation: (V-vertical,H-horizontal)" : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next();
            if(userInput.equalsIgnoreCase("H")) {return 0;}
            else if(userInput.equalsIgnoreCase("V")) {return 1;}
        } while (true);
    }

}
