package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookTableModel {

    public void addBookTable() {
        Connection conn = Database.connectToDatabase();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS book (\n" +
                    "book_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "book_title VARCHAR(255) NOT NULL,\n" +
                    "year INTEGER NOT NULL,\n" +
                    "publisher VARCHAR(255) NOT NULL,\n" +
                    "num_pages INTEGER NOT NULL,\n" +
                    "brief_description TEXT,\n" +
                    "thirteen_digit_isbn_number VARCHAR(30) UNIQUE,\n" +
                    "ten_digit_isbn_number VARCHAR(30) UNIQUE,\n" +
                    "quantity INTEGER NOT NULL,\n" +
                    "copies_available INTEGER NOT NULL\n" +
                    ");";

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
