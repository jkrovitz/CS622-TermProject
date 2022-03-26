package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.*;

public class SearchAuthor {

    public boolean authorCountGreaterThanZero(){
        boolean countGreaterThanZero = false;
        Connection conn = Database.connectToDatabase();
        String sql = "SELECT COUNT(*) AS author_count FROM author";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            if (rs.getInt("author_count") > 0){
                countGreaterThanZero = true;
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return countGreaterThanZero;
    }

    public int getAuthorId(String authorFullName){
        int authorId = 0;
        String sql = "SELECT author_id FROM author " +
                "WHERE author_full_name = ?;";

        Connection conn = Database.connectToDatabase();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, authorFullName);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                authorId = rs.getInt("author_id");
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return authorId;
    }
}
