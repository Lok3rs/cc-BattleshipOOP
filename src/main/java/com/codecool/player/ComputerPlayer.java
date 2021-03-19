package com.codecool.player;

import com.codecool.highscores.Highscore;
import com.codecool.utils.Display;
import com.codecool.utils.Input;

import java.util.Random;

public abstract class ComputerPlayer extends Player{
    private final Random random = new Random();

    public ComputerPlayer(Display display, Input input, Highscore highscore) {
        super(display, input, highscore);
    }

    protected int getRandomCord(){
        return random.nextInt(10);
    }

    protected int[] getRandomCoordinates(){
        return new int[]{getRandomCord(), getRandomCord()};
    }
}

