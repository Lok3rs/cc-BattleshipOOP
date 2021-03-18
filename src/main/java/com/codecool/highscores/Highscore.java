package com.codecool.highscores;

import com.codecool.utils.Display;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Highscore {

    public final String DRIVER = "org.sqlite.JDBC";
    public final String DB_URL = "org.sqlite.highscores.db";

    private Connection conn;
    private Statement stat;
    private final Display display = new Display();

    public Highscore(){
        try {
            Class.forName(this.DRIVER);
        }
        catch(ClassNotFoundException e){
            display.printMessage("No JDBC driver found");
            e.printStackTrace();
        }


        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        }
        catch (SQLException e){
            display.printMessage("Problem with database connection.");
            e.printStackTrace();
        }

        createTables();
    }

    public boolean createTables(){
        String createQuery = "CREATE TABLE IF NOT EXISTS highscores (id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(255), highscore INT)";

        try{
            stat.execute(createQuery);
        } catch (SQLException e){
            display.printMessage("Error occurred while creating table");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean findUser(String username){
        String query = String.format("SELECT * FROM highscores WHERE username=%s", username);

        try{
            ResultSet user = stat.executeQuery(query);
            if (!user.next()) return false;
        } catch (SQLException e){
            display.printMessage("Error with database connection");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateScore(String username, int scoreIncreasing){
        String query = String.format("UPDATE highscores SET highscore = highscore + %d WHERE username = %s", scoreIncreasing, username);

        try {
            stat.execute(query);
        } catch(SQLException e){
            display.printMessage("Error with database connection");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createNewUser(String username, int highscore){
        String query = String.format("INSERT INTO highscores (username, highscore) VALUES (%s, %d)", username, highscore);

        try{
            stat.execute(query);
        }
        catch(SQLException e){
            display.printMessage("Error with database connection");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> getAllScores(){
        List<User> highscores = new LinkedList<User>();
        try {
            ResultSet queryResult = stat.executeQuery("SELECT * FROM highscores ORDER BY highscore DESC");
            int id, score;
            String username;
            while (queryResult.next()){
                id = queryResult.getInt("id");
                score = queryResult.getInt("highscore");
                username = queryResult.getString("username");
                highscores.add(new User(id, username, score));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        return highscores;
    }

    public void closeConnection(){
        try {
            conn.close();
        }
        catch (SQLException e){
            display.printMessage("Error occurred while closing connection with database.");
            e.printStackTrace();
        }
    }
}
