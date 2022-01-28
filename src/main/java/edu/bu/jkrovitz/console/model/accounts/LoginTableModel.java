package edu.bu.jkrovitz.console.model.accounts;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Creates the table called user_info if it does not already exist.
 *
 * @author Jeremy Krovitz
 */
public class LoginTableModel {

    public void addLoginTable() {
        Connection conn = Database.connectToDatabase();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS user_info " + "(user_id INTEGER PRIMARY KEY AUTOINCREMENT," + "username TEXT NOT NULL UNIQUE," + "password TEXT NOT NULL," + "user_type TEXT NOT NULL," + "first_name TEXT NOT NULL," + "last_name TEXT NOT NULL," + "email_address TEXT NOT NULL UNIQUE); ";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}