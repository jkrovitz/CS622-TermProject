package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookAuthorTableModel {

   public void addBookAuthorTable(){
        Connection conn = Database.connectToDatabase();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS book_author (\n" +
                    "book_author_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "book_id INTEGER NOT NULL,\n" +
                    "author_id INTEGER NOT NULL,\n" +
                    "FOREIGN KEY(book_id) REFERENCES book(book_id),\n" +
                    "FOREIGN KEY(author_id) REFERENCES author(author_id)\n" +
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
