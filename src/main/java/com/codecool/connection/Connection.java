package com.codecool.connection;

import com.codecool.utils.Display;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Connection {

    Map<String, String> env = System.getenv();

    private Statement stat;

    public Connection(Display display) {
        final String DRIVER = "org.postgresql.Driver";
        final String DB_URL = String.format("jdbc:postgresql://%s/%s?user=%s&password=%s",
                env.get("PSQL_HOST"), env.get("PSQL_DBNAME"), env.get("PSQL_USER"), env.get("PSQL_PASSWORD"));
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            display.printMessage("No JDBC driver found");
            e.printStackTrace();
        }

        try {
            java.sql.Connection conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            display.printMessage("Problem with database connection.");
            e.printStackTrace();
        }
        createTables();
    }

    public void executeQuery(String query) {
        try {
            stat.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet(String query) {
        try {
            return stat.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createTables() {
        String createQuery = "CREATE TABLE IF NOT EXISTS highscores (id SERIAL PRIMARY KEY, username VARCHAR(255), highscore INT)";
        executeQuery(createQuery);
    }

}
