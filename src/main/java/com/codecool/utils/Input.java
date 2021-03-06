package com.codecool.utils;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    private final Display display;
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    public Input(Display display) {
        this.display = display;
    }

    public int[] getCoordinates() {
        return new int[]{getRowIndex(), getColumnIndex()};
    }

    public String getPlayerName() {
        display.printMessage("Provide a player name: ");
        return scanner.next();
    }

    public int getOption(int minVal, int maxVal) {
        boolean firstTry = true;
        String userInput;
        do {
            display.printMessage(firstTry ? "Select option: " : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next();
        } while (!inputValidator.isValidOptionInput(userInput, minVal, maxVal));
        return Integer.parseInt(userInput);
    }

    public int setShipOrientation() {
        boolean firstTry = true;
        String userInput;
        do {
            display.printMessage(firstTry ? "Provide a ship orientation:\n1 - Horizontal\n2 - Vertical" : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next();
        } while (!inputValidator.isValidOrientationIdentifier(userInput));
        return Integer.parseInt(userInput) - 1;
    }

    public void waitForEnter() throws IOException {
        display.printMessage("Type ENTER to continue...");
        System.in.read();
    }

    private int getRowIndex() {
        int letterAUnicodeDistanceFrom0 = 65;
        boolean firstTry = true;
        String userInput;
        do {
            display.printMessage(firstTry ? "Provide row index: " : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next().toUpperCase();
        } while (!inputValidator.isValidRowInput(userInput));
        return userInput.charAt(0) - letterAUnicodeDistanceFrom0;
    }

    private int getColumnIndex() {
        boolean firstTry = true;
        String userInput;
        do {
            display.printMessage(firstTry ? "Provide column index: " : "Invalid input, try again: ");
            firstTry = false;
            userInput = scanner.next().toUpperCase();
        } while (!inputValidator.isValidColumnInput(userInput) && userInput.length() > 1);
        return Integer.parseInt(userInput) - 1;
    }
}
