package com.codecool.utils;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    public final static char[] alphabet = "ABCDEFGHIJKLMNOPRSTWYZ".toCharArray();
    private final int boardSize = 10;


    public int getRowIndex() {
        System.out.print("Provide row character   ( A - J ) ---> ");
        String rowChar = scanner.next().toUpperCase();
        int rowIndex = new String(alphabet).indexOf(rowChar);
        while (rowIndex == -1 || rowIndex >= boardSize) {
            System.out.print("Invalid row character, try again: ");
            rowChar = scanner.next().toUpperCase();
            rowIndex = new String(alphabet).indexOf(rowChar);
        }
        return rowIndex;
    }

    public int getColumnIndex() {
        int columnIdentifier = 0;
        System.out.print("Provide column number   ( 1 - 10 ) ---> ");
        while (columnIdentifier == 0 || columnIdentifier > boardSize) {
            String columnIndexStr = scanner.next();
            try {
                columnIdentifier = Integer.parseInt(columnIndexStr);
            } catch (NumberFormatException e) {
                System.out.print("Only numbers in range of 1 to 10 allowed, try again: ---> ");
            }
            System.out.print(
                    columnIdentifier == 0 || columnIdentifier > boardSize ? "Only numbers in range of 1 to 10 allowed, try again ---> " : "");
        }
        return columnIdentifier - 1;
    }

}
