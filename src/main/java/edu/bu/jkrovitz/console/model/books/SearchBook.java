package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.*;
import java.util.ArrayList;

public class SearchBook {

    public ArrayList<ArrayList<String>> selectBooks(){
        Connection conn = Database.connectToDatabase();
        ArrayList<ArrayList<String>> tenAndThirteenDigitIsbnNumbers = new ArrayList<>();
        ArrayList<String> tenDigitIsbnNumbers = new ArrayList<>();
        ArrayList<String> thirteenDigitIsbnNumbers = new ArrayList<>();

        String sql = "SELECT book_id, book_title, year, publisher, " +
                "num_pages, brief_description, thirteen_digit_isbn_number, " +
                "ten_digit_isbn_number, quantity, copies_available FROM " +
                "book;";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
        ) {

            while(rs.next()){
                String bookTitle = rs.getString("book_title");
                int year = rs.getInt("year");
                String publisher = rs.getString("publisher");
                int numPages = rs.getInt("num_pages");
                String briefDescription = rs.getString("brief_description");
                String thirteenDigitIsbn = rs.getString("thirteen_digit_isbn_number");
                String tenDigitIsbn = rs.getString("ten_digit_isbn_number");
                int quantity = rs.getInt("quantity");
                int copies = rs.getInt("copies_available");

                thirteenDigitIsbnNumbers.add(thirteenDigitIsbn);
                tenDigitIsbnNumbers.add(tenDigitIsbn);

            }
            tenAndThirteenDigitIsbnNumbers.add(thirteenDigitIsbnNumbers);
            tenAndThirteenDigitIsbnNumbers.add(tenDigitIsbnNumbers);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenAndThirteenDigitIsbnNumbers;
    }

    public ArrayList<Integer> selectQuantityAndCopies(String attributeName, String isbnNumber){
        Connection conn = Database.connectToDatabase();
        ArrayList<Integer> quantityAndCopies = new ArrayList<>();
        String sql = "SELECT book_id, book_title, year, publisher, " +
                "num_pages, brief_description, thirteen_digit_isbn_number, " +
                "ten_digit_isbn_number, quantity, copies_available FROM " +
                "book WHERE " + attributeName + " = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, isbnNumber);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                String bookTitle = rs.getString("book_title");
                int year = rs.getInt("year");
                String publisher = rs.getString("publisher");
                int numPages = rs.getInt("num_pages");
                String briefDescription = rs.getString("brief_description");
                String thirteenDigitIsbn = rs.getString("thirteen_digit_isbn_number");
                String tenDigitIsbn = rs.getString("ten_digit_isbn_number");
                int quantity = rs.getInt("quantity");
                int num_copies = rs.getInt("copies_available");

                quantityAndCopies.add(quantity);
                quantityAndCopies.add(num_copies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantityAndCopies;
    }
}