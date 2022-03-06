package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.*;

public class AuthorModel {

    public int addAuthor(String author) throws SQLException {
        Connection conn = Database.connectToDatabase();
        String[] authorArray = author.split(" ");
        ResultSet rs = null;
        int generatedKey = 0;

        if (authorArray.length == 2){
            String firstName = authorArray[0];
            String lastName = authorArray[1];

            String sql = "INSERT INTO author(author_first_name, author_last_name) VALUES (?, ?)";

            try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.executeUpdate();

                rs = pstmt.getGeneratedKeys();
                if (rs.next()){
                    generatedKey = rs.getInt(1);
                }

            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }


        }
        else if (authorArray.length == 3){
            String firstName = authorArray[0];
            String middleName = authorArray[1];
            String lastName = authorArray[2];

            String sql = "INSERT INTO author(author_first_name, author_middle_name, author_last_name) VALUES (?, ?, ?)";

            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, firstName);
                pstmt.setString(2, middleName);
                pstmt.setString(3, lastName);
                pstmt.executeUpdate();

                rs = pstmt.getGeneratedKeys();
                if (rs.next()){
                    generatedKey = rs.getInt(1);
                }

            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

        }
        conn.close();
        return generatedKey;
    }
}
