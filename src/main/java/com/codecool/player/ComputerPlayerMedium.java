package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;


public class ComputerPlayerMedium extends ComputerPlayer {

    protected final String direction = null;
    protected final int[] lastCords = new int[2];
    protected final int yIndex = 0;
    protected final int xIndex = 0;

    public ComputerPlayerMedium(Display display, Input input, Highscore highscore) {
        super(display, input, highscore);
    }

    @Override
    protected void getCoordsAndShoot(Board shootingBoard, Board enemyBoard) {

    }


}


