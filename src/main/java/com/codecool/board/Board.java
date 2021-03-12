package com.codecool.board;

public class Board {

    private final int size;
    Square[][] gameBoard;

    public Board(int size) {
        this.size = size;
        Square[][] gameBoard = createBoard();
    }

    private Square[][] createBoard() {
        Square[][] gameBoard = new Square[size][size];
        for(int x=0; x<this.size; x++) {
            for(int y=0; y<this.size; y++) {
                gameBoard[x][y] = new Square(y,x,SquareStatus.EMPTY);
            }
        }
        return gameBoard;
    }

    public boolean isPlacementOk(Ship ship) {
        if(ship.getShipOrientation() == ShipOrientation.HORIZONTAL) {
            if (!checkHorizontal(ship.getShipBowX(), ship.getShipBowY(), ship.shipType.getShipLength())) {
                return false;
            };
            return true;
        } else {
            System.out.println("VERTICAL");
            if (!checkVertical(ship.getShipBowX(), ship.getShipBowY(), ship.shipType.getShipLength())) {
                return false;
            };
            return true;
        }
    }

    private boolean checkHorizontal(int X, int Y, int shipSize) {
        //check if possible put this ship size on game board
        if (Y>(this.size-shipSize)) {
            System.out.println("Ship out of game board");
            return false;}
        //default range
        int posXmin = X-1;
        int posXmax = X+2;
        int posYmin = Y-1;
        int posYmax = Y+shipSize+1;
        //correction if ship on boundary
        if (X==0) {posXmin=0;}
        if (X==this.size-1) {posXmax=X+1;}
        if (Y==0) {posYmin=0;}
        if (Y==this.size-shipSize) {posYmax=this.size;}
        //check if empty fields in ship area
        for(int x=posXmin;x<posXmax;x++) {
            for (int y = posYmin; y < posYmax; y++) {
                System.out.println("XY"+x+y);
                if(gameBoard[x][y].getSquareStatus() == SquareStatus.SHIP) {   //!= WATER_SIGN
                    System.out.println("Ship in collision");
                    return false;
                }
            }
        }
        System.out.println("Ship OK");
        return true;
    }

    private boolean checkVertical(int X,int Y, int shipSize) {
        //check if possible put this ship on game board
        if (X>(this.size-shipSize)) {
            System.out.println("Ship out of game board");
            return false;}
        //default range
        int posXmin = X-1;
        int posXmax = X+shipSize+1;
        int posYmin = Y-1;
        int posYmax = Y+2;
        //correction if ship on boundary
        if (X==0) {posXmin=0;}
        if (X==this.size-shipSize) {posXmax=this.size;}
        if (Y==0) {posYmin=0;}
        if (Y==this.size-1) {posYmax=Y+1;}
        //check if empty fields in ship area
        for(int x=posXmin;x<posXmax;x++) {
            for (int y = posYmin; y < posYmax; y++) {
                System.out.println("XY"+x+y);
                if(gameBoard[x][y].getSquareStatus() == SquareStatus.SHIP) {   //!= WATER_SIGN
                    System.out.println("Ship in collision");
                    return false;
                }
            }
        }
        System.out.println("Ship OK");
        return true;
    }



}



/*    static String[] labelX = new String[sizeX];
    static String[] labelY = new String[sizeY];


    static String WATER_SIGN = " # ";
    static String SHIP_SIGN = " S ";
    static String BUFFOR_SIGN = " . ";
    static String SHIP_SIGN2 = " s ";

    public static void main(String[] args) {
        createBoard();
        createLabels();
        displayBoard();
        randomPlacement();
        displayBoard();
    }

    //////////////////////////////////
    private static void createBoard() {
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                gameBoard[x][y] = WATER_SIGN;
            }
        }
    }

    public static boolean isPlacementOk(int direction, int X, int Y, int size){
        if (!checkStartPosition(X, Y)) {
            return false;
        };
        if(direction==0) {
            System.out.println("HORIZONTAL");
            if (!checkHorizontal(X, Y, size)) {
                return false;
            };
            return true;
        } else {
            System.out.println("VERTICAL");
            if (!checkVertical(X, Y, size)) {
                return false;
            };
            return true;
        }
    }

    private static boolean checkStartPosition(int X, int Y){
        if(gameBoard[X][Y] == WATER_SIGN) {
            return true;
        }
        System.out.print("-Position not avaliable");
        return false;
    }

    private static boolean checkHorizontal(int X,int Y, int shipSize) {
        //check if possible put this ship size on game board
        if (Y>(sizeY-shipSize) || Y<0) {
            System.out.println("Ship out of game board");
            return false;}

        //default range
        int posXmin = X-1;
        int posXmax = X+2;
        int posYmin = Y-1;
        int posYmax = Y+shipSize+1;

        //correction if ship on boundary
        if (X==0) {posXmin=0;}
        if (X==sizeX-1) {posXmax=X+1;}
        if (Y==0) {posYmin=0;}
        if (Y==sizeY-shipSize) {posYmax=sizeY;}

        //check if empty fields in ship area
        for(int x=posXmin;x<posXmax;x++) {
            for (int y = posYmin; y < posYmax; y++) {
                System.out.println("XY"+x+y);
                if(gameBoard[x][y] == SHIP_SIGN2) {   //!= WATER_SIGN
                    System.out.println("Ship in collision");
                    return false;
                }
            }
        }
        System.out.println("Ship OK");
        return true;
    }

    private static boolean checkVertical(int X,int Y, int shipSize) {
        //check if possible put this ship on game board
        if (X>(sizeX-shipSize) || X<0) {
            System.out.println("Ship out of game board");
            return false;}

        //default range
        int posXmin = X-1;
        int posXmax = X+shipSize+1;
        int posYmin = Y-1;
        int posYmax = Y+2;

        //correction if ship on boundary
        if (X==0) {posXmin=0;}
        if (X==sizeX-shipSize) {posXmax=sizeX;}
        if (Y==0) {posYmin=0;}
        if (Y==sizeY-1) {posYmax=Y+1;}

        //check if empty fields in ship area
        for(int x=posXmin;x<posXmax;x++) {
            for (int y = posYmin; y < posYmax; y++) {
                System.out.println("XY"+x+y);
                if(gameBoard[x][y] == SHIP_SIGN2) {   //!= WATER_SIGN
                    System.out.println("Ship in collision");
                    return false;
                }
            }
        }
        System.out.println("Ship OK");
        return true;
    }*/


