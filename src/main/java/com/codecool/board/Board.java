package com.codecool.board;

import com.codecool.board.enums.SquareStatus;

import java.util.List;

public class Board {
    private final int boardSize = 10;
    private final Square[][] gameBoard = new Square[boardSize][boardSize];

    public Board(){
        createBoard();
    }

    private void createBoard(){
        for (int y = 0; y < gameBoard.length; y++){
            for (int x = 0; x < gameBoard[y].length; x++){
                gameBoard[y][x] = new Square(y, x, SquareStatus.EMPTY);
            }
        }
    }

    public Square[][] getGameBoard() {
        return gameBoard;
    }

    public boolean isPlacementOk(Ship ship){
        return !isShipOutOfBounds(ship) && !isAdjacentToAnotherBoat(ship);
    }

    private boolean isShipOutOfBounds(Ship ship){
        for (Square shipPiece : ship.getShipContent()){
            if(shipPiece.getX() >= gameBoard.length || shipPiece.getY() >= gameBoard.length){
                return true;
            }
        }
        return false;
    }

    private boolean isAdjacentToAnotherBoat(Ship ship){
        List<Square> shipPieces = ship.getShipContent();
        int counter = 0;
        for (Square shipPiece : shipPieces){
            int currentY = shipPiece.getY();
            int currentX = shipPiece.getX();
            boolean isFirstElement = counter == 0;
            boolean isLastElement = counter == shipPieces.size() - 1;
            boolean isInFirstRow = shipPiece.getY() == 0;
            boolean isInLastRow = shipPiece.getY() == gameBoard.length - 1;
            boolean isInFirstColumn = shipPiece.getX() == 0;
            boolean isInLastColumn = shipPiece.getX() == gameBoard.length - 1;
            boolean isAdjacentOnLeft = !isInFirstColumn && isFieldFilled(currentY, currentX - 1);
            boolean isAdjacentOnRight = !isInLastColumn && isFieldFilled(currentY, currentX + 1);
            boolean idAdjacentOnTop = isFirstElement && !isInFirstRow && isFieldFilled(currentY - 1, currentX);
            boolean isAdjacentOnBottom = isLastElement && !isInLastRow && isFieldFilled(currentY + 1, currentX);
            boolean isAdjacentTopLeft = isFirstElement && !isInFirstRow && !isInFirstColumn && isFieldFilled(currentY - 1, currentX - 1);
            boolean isAdjacentTopRight = isFirstElement && !isInFirstRow && !isInLastColumn && isFieldFilled(currentY - 1, currentX+ 1);
            boolean isAdjacentBottomLeft = isLastElement && !isInLastRow && !isInFirstColumn && isFieldFilled(currentY + 1, currentX - 1);
            boolean isAdjacentBottomRight = isLastElement && !isInLastRow && !isInLastColumn && isFieldFilled(currentY + 1, currentX + 1);
            boolean isAdjacentAnywhere = isAdjacentOnRight || isAdjacentOnLeft || idAdjacentOnTop || isAdjacentOnBottom || isAdjacentTopLeft || isAdjacentTopRight || isAdjacentBottomLeft || isAdjacentBottomRight;
            if (isAdjacentAnywhere) return true;
            counter++;
        }
        return false;
    }

    private boolean isFieldFilled(int y, int x){
        return gameBoard[y][x].getSquareStatus() != SquareStatus.EMPTY;
    }

    public boolean isShipSunk(int y, int x){
        return checkIfSunkTop(y, x) && checkIfSunkRight(y, x) && checkIfSunkBottom(y, x) && checkIfSunkLeft(y, x);
    }

    private boolean checkIfSunkTop(int y, int x){
        if (gameBoard[y][x].getSquareStatus() == SquareStatus.SHIP){
            return false;
        } else if (gameBoard[y][x].getSquareStatus() == SquareStatus.EMPTY || y == 0){
            return true;
        } else {
            return checkIfSunkTop(y - 1, x);
        }
    }

    private boolean checkIfSunkRight(int y, int x){
        if (gameBoard[y][x].getSquareStatus() == SquareStatus.SHIP){
            return false;
        } else if (gameBoard[y][x].getSquareStatus() == SquareStatus.EMPTY || x == gameBoard.length - 1){
            return true;
        } else {
            return checkIfSunkRight(y, x + 1);
        }
    }
    private boolean checkIfSunkBottom(int y, int x){
        if (gameBoard[y][x].getSquareStatus() == SquareStatus.SHIP){
            return false;
        } else if (gameBoard[y][x].getSquareStatus() == SquareStatus.EMPTY || y == gameBoard.length - 1){
            return true;
        } else {
            return checkIfSunkBottom(y + 1, x);
        }
    }
    private boolean checkIfSunkLeft(int y, int x){
        if (gameBoard[y][x].getSquareStatus() == SquareStatus.SHIP){
            return false;
        } else if (gameBoard[y][x].getSquareStatus() == SquareStatus.EMPTY || x == 0){
            return true;
        } else {
            return checkIfSunkLeft(y, x - 1);
        }
    }
}
