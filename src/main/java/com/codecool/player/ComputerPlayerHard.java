package com.codecool.player;

import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

public class ComputerPlayerHard extends ComputerPlayerMedium {
    private boolean shootingDiagonally = false;
    private int[] lastCoords;

    public ComputerPlayerHard(Display display, Input input, Highscore highscore) {
        super(display, input, highscore);
    }

    @Override
    protected int[] getShootCoords() {
        if (!checkAround) {
            shootCoords = shootingDiagonally ? getDiagonalCoords() : new int[]{getRandomCord(), getRandomCord()};
            shootingDiagonally = true;
        } else {
            shootCoords = getAroundCoords(shootCoords, checkState);
        }
        lastCoords = shootCoords;
        return shootCoords;
    }

    private int[] getDiagonalCoords() {
        if (lastCoords[yIndex] >= 9 || lastCoords[xIndex] >= 9) {
            return new int[]{getRandomCord(), getRandomCord()};
        } else {
            return new int[]{lastCoords[yIndex] + 1, lastCoords[xIndex] + 1};
        }
    }
}
