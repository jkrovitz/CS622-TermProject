package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.*;

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

    public int searchBookAndAuthor(String bookTitle, String authorName){
        boolean found = false;
        int bookId = 0;
        Connection conn = Database.connectToDatabase();
        ResultSet resultSet = null;
            String sql = "SELECT " +
                    " book_id " +
                    "FROM book " +
                        "JOIN book_author USING (book_id) " +
                        "JOIN author USING (author_id) " +
                    "WHERE book.book_title = ? " +
                    "AND author.author_full_name = ?;";

        return findId(bookTitle, authorName, bookId, conn, sql);
    }

    private int findId(String attribute1, String attribute2, int bookId, Connection conn, String sql) {
        ResultSet resultSet;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, attribute1);
            pstmt.setString(2, attribute2);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                bookId = resultSet.getInt("book_id");
            }
        } catch(SQLException sqlException) {
            System.out.println(sql);
        }
        return bookId;
    }

    public int searchIsbn(String tenOrThirteenDigitIsbnInput) {
        int bookId = 0;
        Connection conn = Database.connectToDatabase();
        ResultSet resultSet = null;
        String sql = "SELECT " +
                " book_id " +
                "FROM book " +
                "JOIN book_author USING (book_id) " +
                "JOIN author USING (author_id) " +
                "WHERE book.thirteen_digit_isbn_number = ? " +
                "OR book.ten_digit_isbn_number = ?;";

        return findId(tenOrThirteenDigitIsbnInput, tenOrThirteenDigitIsbnInput, bookId, conn, sql);
    }

    public void displayBookAndAuthor(int bookId){
        boolean found = false;
        Connection conn = Database.connectToDatabase();
        ResultSet resultSet = null;
        String sql = "SELECT " +
                        "book.book_title, " +
                        "author.author_full_name, " +
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
                "WHERE book.book_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, bookId);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                System.out.println("Book title: " + (resultSet.getString("book_title")));
                System.out.println("Author: " + (resultSet.getString("author_full_name")));
                System.out.println("Year: " + (resultSet.getInt("year")));
                System.out.println("Publisher: " + (resultSet.getString("publisher")));
                System.out.println("Number of Pages: " + (resultSet.getInt("num_pages")));
                System.out.println("Brief Description: " + (resultSet.getString("brief_description")));
                System.out.println("Thirteen Digit ISBN Number: " + (resultSet.getString("thirteen_digit_isbn_number")));
                System.out.println("Ten Digit ISBN Number: " + (resultSet.getString("ten_digit_isbn_number")));
                System.out.println("Quantity: " + (resultSet.getInt("quantity")));
                System.out.println("Copies Available: " + (resultSet.getInt("copies_available")) + "\n");
            }

        } catch(SQLException sqlException) {
            System.out.println(sql);
        }
    }


}
