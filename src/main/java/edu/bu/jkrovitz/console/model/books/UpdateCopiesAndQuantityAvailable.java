package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCopiesAndQuantityAvailable {

    public void updateForThirteenDigitIsbn(int copies, int quantityAvailable, String thirteenDigitIsbn) throws SQLException {
        Connection conn = Database.connectToDatabase();

        String sql = "UPDATE book SET quantity = ? , " +
                "copies_available = ? " +
                "WHERE thirteen_digit_isbn_number = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, copies);
            pstmt.setInt(2, quantityAvailable);
            pstmt.setString(3, thirteenDigitIsbn);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
    }

    public void updateForTenDigitIsbn(int copies, int quantityAvailable, String tenDigitIsbn) throws SQLException {
        Connection conn = Database.connectToDatabase();

        String sql = "UPDATE book SET quantity = ? , " +
                "copies_available = ? " +
                "WHERE ten_digit_isbn_number = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, copies);
            pstmt.setInt(2, quantityAvailable);
            pstmt.setString(3, tenDigitIsbn);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
    }
}
