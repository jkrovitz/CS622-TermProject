package edu.bu.jkrovitz.console.model;

import edu.bu.jkrovitz.console.model.accounts.LoginTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String DATABASE_URL = "jdbc:sqlite:./src/main/resources/edu.bu.jkrovitz.database/lms.sqlite";

    public static Connection connectToDatabase() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() throws SQLException {
        LoginTableModel loginTableModel = new LoginTableModel();
        loginTableModel.addLoginTable();
    }
}
