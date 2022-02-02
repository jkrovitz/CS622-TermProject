package edu.bu.jkrovitz.console.model.accounts;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProfileAttributes {
    public void updateProfileAttribute(String attributeToUpdate, String updatedAttribute, String role, String username) throws SQLException {
        Connection conn = Database.connectToDatabase();
        String sql = "UPDATE user_info " +
                "SET " + attributeToUpdate + " = ? " +
                "WHERE username = ? AND user_type = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, updatedAttribute);
            pstmt.setString(2, username);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            System.out.println("Update has been executed successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }
}
