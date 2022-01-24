package edu.bu.jkrovitz.console.model.accounts;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.*;

public class RegisterModel {

    public void register(String username, String password, String roleType, String emailAddress, String firstName, String lastName) throws SQLException {
        Connection conn = Database.connectToDatabase();
        String sql = "INSERT INTO user_info(" +
                "username,password,user_type,first_name," +
                "last_name, email_address) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement((sql))){

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, roleType);
            pstmt.setString(4, firstName);
            pstmt.setString(5, lastName);
            pstmt.setString(6, emailAddress);
            pstmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
}
