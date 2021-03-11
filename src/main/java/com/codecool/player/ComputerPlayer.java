package com.codecool.player;

import com.codecool.board.Ship;

import java.util.List;

public class ComputerPlayer extends Player{
    public ComputerPlayer(int id, String name, int score, List<Ship> ships, boolean isAlive) {
        super(id, name, score, ships, isAlive);
    }
}
