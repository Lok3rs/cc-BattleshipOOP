package com.codecool.player;

import com.codecool.board.Ship;
import com.codecool.board.ShipCollection;

import java.util.List;

public class ComputerPlayer extends Player{
    public ComputerPlayer(int id, String name, int score, boolean isAlive, ShipCollection ships) {
        super(id, name, score, isAlive, ships);
    }
}

