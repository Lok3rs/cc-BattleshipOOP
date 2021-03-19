package com.codecool.player;

import java.util.Random;

public abstract class ComputerPlayer extends Player{
    private final Random random = new Random();

    public int getRandomNumber(){
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }
    public int[] getRandomCoordinates(){
        return new int[]{random.nextInt(10), random.nextInt(10)};
    }
}

