package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAuthorModel {
    public void addBookAuthor(int bookId, int authorId) throws SQLException {
        Connection conn = Database.connectToDatabase();

        String sql = "INSERT INTO book_author(book_id, author_id) VALUES(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, authorId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
    }
}
