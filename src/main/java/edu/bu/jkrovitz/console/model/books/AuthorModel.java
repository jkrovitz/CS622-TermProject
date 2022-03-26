package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.*;

public class AuthorModel {

    public int addAuthor(String author) throws SQLException {
        Connection conn = Database.connectToDatabase();
        ResultSet rs = null;
        int generatedKey = 0;

        String sql = "INSERT INTO author(author_full_name) VALUES (?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, author);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        conn.close();
        return generatedKey;
    }
}
