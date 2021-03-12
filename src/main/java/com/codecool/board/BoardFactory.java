package com.codecool.board;

public class BoardFactory {

    private final Board gameBoard = new Board(10);

    private void randomPlacement(ShipCollection ships) {

        for(Ship ship: ships.getShips()) {
            ShipOrientation direction;
            int posX;
            int posY;
            do {
                direction = (int) (Math.random() * 2) == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL;
                ship.setShipOrientation(direction);
                ship.setShipBowX((int) (Math.random() * 10));
                ship.setShipBowY((int) (Math.random() * 10));
            }  while (!gameBoard.isPlacementOk(ship));
            ship.placeShip();
        }



/*        int[] ShipsLength = {4,3,3,2,2,2,1,1,1,1};

        for (int ship: ShipsLength) {
            int direction;
            int posX;
            int posY;
            do {
                direction = (int) (Math.random() * 2); //0=H,1=V
                posX = (int) (Math.random() * 10);
                posY = (int) (Math.random() * 10);
                System.out.println();
                System.out.print("SHIP_:" + ship + " Direction: " + direction);
                System.out.print("posX: " + posX + " posY: " + posY);
                System.out.println();
            } while (!Board.isPlacementOk(direction,posX, posY, ship));
            Ship ship1 = new Ship(ShipType.Battleship, ShipOrientation.HORIZONTAL, posY, posX);
        }
        System.out.println("\n");*/
    }


/*    private static void displayBoard() {
        System.out.print("  ");
        for(String labY: labelY){ System.out.print(" "+labY+" ");}
        System.out.println();
        for(int x=0; x<sizeX; x++) {
            System.out.print(labelX[x]+"|");
            for(int y=0; y<sizeY; y++) {
                System.out.print(gameBoard[x][y]);
            }
            System.out.println();
        }
    }
    private static void createLabels(){
        for(int x =0; x<sizeX;x++) {
            labelX[x] = String.valueOf(x);
        }
        for(int y =0; y<sizeY;y++) {
            labelY[y] = String.valueOf(y);
        }
    }*/

/*    public static int sizeX = 10;
    public static int sizeY = 10;

    static String WATER_SIGN = " # ";
    static String SHIP_SIGN = " S ";
    static String BUFFOR_SIGN = " . ";
    static String SHIP_SIGN2 = " s ";

    static String[][] gameBoard = new String[sizeX][sizeY];


    private static void randomPlacement() {
        int[] ShipsLength = {4,3,3,2,2,2,1,1,1,1};

        for (int ship: ShipsLength) {
            int direction;
            int posX;
            int posY;
            do {
                direction = (int) (Math.random() * 2); //0=H,1=V
                posX = (int) (Math.random() * 10);
                posY = (int) (Math.random() * 10);
                System.out.println();
                System.out.print("SHIP_:" + ship + " Direction: " + direction);
                System.out.print("posX: " + posX + " posY: " + posY);
                System.out.println();
            } while (!Board.isPlacementOk(direction,posX, posY, ship));
            Ship ship1 = new Ship(ShipType.Battleship, ShipOrientation.HORIZONTAL, posY, posX);
        }
        System.out.println("\n");
    }

    private static void createBuffor(int posX,int posY,int shipLength,int direction) {
        System.out.println("DIRECTION == "+direction);
        if(direction==0) {
            createBufforHorizontal(posX,posY, shipLength);
        } else {
            createBufforVertical(posX,posY, shipLength);
        }
    }
    private static void createShip(int posX,int posY,int shipLength,int direction) {
        if(direction==0) {
            createShipHorizontal(posX,posY, shipLength);
        } else {
            createShipVertical(posX,posY, shipLength);
        }
    }

    private static void createBufforHorizontal(int X, int Y, int shipSize) {
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
                gameBoard[x][y] = BUFFOR_SIGN;
            }
        }
    }

    private static void createBufforVertical(int X,int Y, int shipSize) {
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
                gameBoard[x][y] = BUFFOR_SIGN;
            }
        }
    }

    private static void createShipHorizontal(int X, int Y, int shipSize) {
        //range
        int posYmin = Y;
        int posYmax = Y+shipSize;
        //create ship
        for(int y=posYmin;y<posYmax;y++) {
            gameBoard[X][y] = SHIP_SIGN2;
        }
    }

    private static void createShipVertical(int X,int Y, int shipSize) {
        //range
        int posXmin = X;
        int posXmax = X+shipSize;
        //create ship
        for(int x=posXmin;x<posXmax;x++) {
            gameBoard[x][Y] = SHIP_SIGN2;
        }
    }*/


    public void manualPlacement() {}
}
