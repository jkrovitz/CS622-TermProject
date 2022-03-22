package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchBookAndDisplay {

    public ResultSet searchBook(String sql, String firstJavaValue, String secondJavaValue){
        ResultSet resultSet = null;
        Connection conn = Database.connectToDatabase();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, firstJavaValue);
            pstmt.setString(2, secondJavaValue);
            resultSet = pstmt.executeQuery();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return resultSet;
    }

    public ResultSet searchBookAndAuthor(String bookTitle, String authorName){
        AuthorStringManipulation authorStringManipulation = new AuthorStringManipulation();
        String[] authorArray = authorStringManipulation.createAuthorArray(authorName);
        String sql = "";
        Connection conn = Database.connectToDatabase();
        ResultSet resultSet = null;
        if (authorArray.length == 2){
            sql = "SELECT " +
                        "book.book_title, " +
                        "author.author_first_name, " +
                        "author.author_last_name, " +
                        "book.year, " +
                        "book.publisher, " +
                        "book.num_pages, " +
                        "book.brief_description, " +
                        "book.thirteen_digit_isbn_number, " +
                        "book.ten_digit_isbn_number, " +
                        "book.quantity, " +
                        "book.copies_available " +
                    "FROM book " +
                        "JOIN book_author USING (book_id) " +
                        "JOIN author USING (author_id) " +
                    "WHERE book.book_title = ? " +
                    "AND author.author_first_name = ?" +
                    "AND author.author_last_name = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, bookTitle);
                pstmt.setString(2, authorArray[0]);
                pstmt.setString(3, authorArray[1]);

                resultSet = pstmt.executeQuery();

            } catch(SQLException sqlException) {
                System.out.println(sql);
            }
        }
        else if (authorArray.length == 3){
            sql = "SELECT " +
                    "book.book_title, " +
                    "author.author_first_name, " +
                    "author.author_middle_name, " +
                    "author.author_last_name, " +
                    "book.year, " +
                    "book.publisher, " +
                    "book.num_pages, " +
                    "book.brief_description, " +
                    "book.thirteen_digit_isbn_number, " +
                    "book.ten_digit_isbn_number, " +
                    "book.quantity, " +
                    "book.copies_available " +
                    "FROM book " +
                    "JOIN book_author USING (book_id) " +
                    "JOIN author USING (author_id) " +
                    "WHERE book.book_title = ? " +
                    "AND author.author_first_name = ? " +
                    "AND author.author_middle_name = ? " +
                    "AND author.author_last_name = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, bookTitle);
                pstmt.setString(2, authorArray[0]);
                pstmt.setString(3, authorArray[1]);
                pstmt.setString(4, authorArray[2]);

                resultSet = pstmt.executeQuery();

            } catch(SQLException sqlException) {
                System.out.println(sql);
            }
        }
        return resultSet;
    }
}
