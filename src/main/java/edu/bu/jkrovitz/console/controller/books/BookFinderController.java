package edu.bu.jkrovitz.console.controller.books;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import edu.bu.jkrovitz.console.exceptions.book.IsbnException;
import edu.bu.jkrovitz.console.model.books.Book;
import edu.bu.jkrovitz.console.model.books.BookFileModel;
import edu.bu.jkrovitz.console.model.books.SearchBookAndDisplay;
import edu.bu.jkrovitz.console.view.books.BookFinderView;
import edu.bu.jkrovitz.console.view.books.BookValidateView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class BookFinderController handles finding a book in the system
 * and outputting an appropriate message if it does not exist.
 *
 * @author Jeremy Krovitz
 */
public class BookFinderController {
    private static final String BOOK_JSON_FILE = "./src/main/resources/edu.bu.jkrovitz.json/books.json";
    private BookFinderView bookFinderView = new BookFinderView();
    private BookFileModel bookFileModel = new BookFileModel();
    private static Logger logger = LogManager.getLogger(BookFinderController.class);

    public void findBookByTitleAndAuthor() {
        String bookTitle = bookFinderView.findBookByTitle();
        String bookAuthor = bookFinderView.findBookByAuthor();
        SearchBookAndDisplay searchBookAndDisplay = new SearchBookAndDisplay();
        int bookId = searchBookAndDisplay.searchBookAndAuthor(bookTitle, bookAuthor);
        if (bookId != 0) {
            System.out.println("\nBook found:");
            searchBookAndDisplay.displayBookAndAuthor(bookId);
        }
        else {
            System.out.println("\nBook with title \"" + bookTitle + "\" and author \"" + bookAuthor + "\" has not been found.\n");
        }
    }

    public void findBookByIsbn() {
        String tenOrThirteenDigitIsbnInput = bookFinderView.findBookByTenOrThirteenDigitISBNNumber();
        SearchBookAndDisplay searchBookAndDisplay = new SearchBookAndDisplay();
        int bookId = searchBookAndDisplay.searchIsbn(tenOrThirteenDigitIsbnInput);
        if (bookId != 0) {
            System.out.println("\nBook found:");
            searchBookAndDisplay.displayBookAndAuthor(bookId);
        }
        else {
            System.out.println("\nBook with ISBN number \"" + tenOrThirteenDigitIsbnInput + "\" was not found.");
        }

    }
}
