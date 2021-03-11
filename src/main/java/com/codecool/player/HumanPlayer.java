package com.codecool.player;

import com.codecool.board.Ship;

import java.util.List;

public class HumanPlayer extends Player {
    public HumanPlayer(int id, String name, int score, List<Ship> ships, boolean isAlive) {
        super(id, name, score, ships, isAlive);
    }
}
