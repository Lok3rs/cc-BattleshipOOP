package com.codecool.users;

public class User {
    private final int id;
    private final String username;
    private final int score;

    public User(int id, String username, int score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }
}
