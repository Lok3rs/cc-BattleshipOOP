package com.codecool.player;

import java.util.Random;

public abstract class ComputerPlayer extends Player{
    protected final String name="Computer";
    private final Random random = new Random();

    public int[] getRandomCoordinates(){
        return new int[]{random.nextInt(10), random.nextInt(10)};
    }
}

