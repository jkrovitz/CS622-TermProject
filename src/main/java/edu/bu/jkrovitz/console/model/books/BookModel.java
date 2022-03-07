package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookModel {
    public int addBook(String title, int year, String publisher, int pages, String briefDescription, String thirteenDigitISBN, String tenDigitISBN, int quantityAvailable, int copies) throws SQLException {
       Connection conn = Database.connectToDatabase();
       ResultSet rs = null;
        int generatedKey = 0;

        String sql = "INSERT INTO book(book_title, year, publisher,num_pages, brief_description, thirteen_digit_isbn_number, ten_digit_isbn_number, quantity, copies_available) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, year);
            pstmt.setString(3, publisher);
            pstmt.setInt(4, pages);
            pstmt.setString(5, briefDescription);
            pstmt.setString(6, thirteenDigitISBN);
            pstmt.setString(7, tenDigitISBN);
            pstmt.setInt(8, quantityAvailable);
            pstmt.setInt(9, copies);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
        return generatedKey;
    }
}
