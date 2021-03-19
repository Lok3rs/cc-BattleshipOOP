package com.codecool.highscores;

import com.codecool.connection.Connection;
import com.codecool.utils.Display;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Highscore {

    private final Connection conn;

    public Highscore(Display display) {
        this.conn = new Connection(display);
        createTables();
    }

    private void createTables() {
        String createQuery = "CREATE TABLE IF NOT EXISTS highscores (id SERIAL PRIMARY KEY, username VARCHAR(255), highscore INT)";
        conn.executeQuery(createQuery);
    }

    public boolean findUser(String username) {
        String query = String.format("SELECT * FROM highscores WHERE username = '%s'", username);
        ResultSet user = conn.getResultSet(query);
        try {
            if (!user.next()) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void updateScore(String username, int scoreIncreasing) {
        String query = String.format("UPDATE highscores SET highscore = highscore + %d WHERE username = '%s'", scoreIncreasing, username);
        conn.executeQuery(query);
    }

    public void createNewUser(String username, int highscore) {
        String query = String.format("INSERT INTO highscores (username, highscore) VALUES ('%s', %d)", username, highscore);
        conn.executeQuery(query);
    }

    public List<User> getAllScores() {
        List<User> highscores = new LinkedList<>();
        try {
            ResultSet queryResult = conn.getResultSet("SELECT * FROM highscores ORDER BY highscore DESC");
            int id, score;
            String username;
            while (queryResult.next()) {
                id = queryResult.getInt("id");
                score = queryResult.getInt("highscore");
                username = queryResult.getString("username");
                highscores.add(new User(id, username, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return highscores;
    }
}
