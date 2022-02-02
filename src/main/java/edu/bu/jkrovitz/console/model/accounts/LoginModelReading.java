package edu.bu.jkrovitz.console.model.accounts;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Retrieves user information from the database.
 *
 * @author Jeremy Krovitz
 */
public class LoginModelReading {

    public ResultSet  retrieveFromDatabase(String role, String username, String password, Connection conn) throws SQLException {
        String query = "SELECT * FROM user_info WHERE username = ? AND password = ? AND user_type = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, role);
        return stmt.executeQuery();
    }

    public boolean validateLogin(String role, String username, String password) throws SQLException{
        boolean result = false;
        Connection conn = Database.connectToDatabase();
        ResultSet resultSet = retrieveFromDatabase(role, username, password, conn);
        if (resultSet.next()) {
            result = true;
        }
        conn.close();
        return result;
    }

    public void displayResultsSet(String role, String username, String password) throws SQLException {

        try (Connection conn = Database.connectToDatabase();
             ResultSet resultSet = retrieveFromDatabase(role, username, password, conn)){
            while (resultSet.next()){
                System.out.println("\nProfile Information for " + (resultSet.getString("username") + ":\n" +
                        "First Name: " + resultSet.getString("first_name") + "\n" +
                        "Last Name: " + resultSet.getString("last_name") + "\n" +
                        "User Type: " + resultSet.getString("user_type") + "\n" +
                        "Email Address: " + resultSet.getString("email_address") + "\n"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
