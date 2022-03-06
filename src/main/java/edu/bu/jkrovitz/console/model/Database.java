package edu.bu.jkrovitz.console.model;

import edu.bu.jkrovitz.console.model.accounts.LoginTableModel;
import edu.bu.jkrovitz.console.model.books.AuthorTableModel;
import edu.bu.jkrovitz.console.model.books.Book;
import edu.bu.jkrovitz.console.model.books.BookAuthorTableModel;
import edu.bu.jkrovitz.console.model.books.BookTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Sets up database connection and uses a master function to call other
 * function to create the database table.
 *
 * @author Jeremy Krovitz
 */
public class Database {

    private final static String DATABASE_URL = "jdbc:sqlite:./src/main/resources/edu.bu.jkrovitz.database/lms.sqlite";

    public static Connection connectToDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        LoginTableModel loginTableModel = new LoginTableModel();
        loginTableModel.addLoginTable();
        BookTableModel bookTableModel = new BookTableModel();
        bookTableModel.addBookTable();
        AuthorTableModel authorTableModel = new AuthorTableModel();
        authorTableModel.addAuthorTable();
        BookAuthorTableModel bookAuthorTableModel = new BookAuthorTableModel();
        bookAuthorTableModel.addBookAuthorTable();
    }
}
