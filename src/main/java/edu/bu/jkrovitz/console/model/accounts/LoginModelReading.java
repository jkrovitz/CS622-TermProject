package edu.bu.jkrovitz.console.model.accounts;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Retrieves user information from the database.
 *
 * @author Jeremy Krovitz
 */
public class LoginModelReading {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return this.password;
    }

    public String setEncryptedPassword(String password) {
        password = PasswordEncryption.encrypt(this.password);
        this.password = password;
        return this.password;
    }

    public boolean retrieveFromDatabase(String role, String username, String password) throws SQLException {
        boolean result = false;
        String query = "SELECT * FROM user_info WHERE username = ? AND password = ? AND user_type = ?";
        PreparedStatement stmt = Database.connectToDatabase().prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, role);
        ResultSet res = stmt.executeQuery();
        if (res.next()) {
            result = true;
        }
        return result;
    }
}
