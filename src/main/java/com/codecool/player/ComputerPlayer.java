package com.codecool.player;

import java.util.Random;

public abstract class ComputerPlayer extends Player{

    public int getRandomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(10) -1;
        return randomNumber;
    }
}

