package edu.bu.jkrovitz.console.controller.books;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import edu.bu.jkrovitz.console.exceptions.book.IsbnException;
import edu.bu.jkrovitz.console.model.books.Book;
import edu.bu.jkrovitz.console.model.books.BookFileModel;
import edu.bu.jkrovitz.console.view.books.BookFinderView;
import edu.bu.jkrovitz.console.view.books.BookValidateView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
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
    private Book book = new Book();
    private static Logger logger = LogManager.getLogger(BookFinderController.class);

    public boolean findBookByTitleAndAuthor() {
        JsonParser jsonParser = new JsonParser();
        File file = new File(bookFileModel.getBookFile());

        String titleInput = bookFinderView.findBookByTitle();
        String authorInput = bookFinderView.findBookByAuthor();

        Gson gson = new Gson();
        boolean found = false;
        try {
            FileWriter fileWriter = new FileWriter(BOOK_JSON_FILE, true);

            if (file.length() == 0) {
                System.out.println("There are no books in this file.");
                fileWriter.close();
            }
            else {
                Reader reader = new FileReader(BOOK_JSON_FILE);
                JsonArray jsonArray = (JsonArray) jsonParser.parse(reader);

                Type listType = new TypeToken<ArrayList<Book>>() {
                }.getType();
                List<Book> bookList = new Gson().fromJson(jsonArray, listType);

                for (Book bm : bookList) {
                    if ((bm.getTitle().equals(titleInput)) && (bm.getAuthor().equals(authorInput))) {
                        System.out.println("\nThe book with title \"" + titleInput + "\" and author \"" + authorInput + "\" has been found:");
                        System.out.println(bm.toString());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("\nThe book with title \"" + titleInput + "\" and author \"" + authorInput + "\" was not found.");
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage().toString());
        }
        return found;
    }

    public boolean findBookByTenOrThirteenDigitIsbn() {
        JsonParser jsonParser = new JsonParser();
        File file = new File(bookFileModel.getBookFile());

        String isbnInput = bookFinderView.findBookByTenOrThirteenDigitISBNNumber();

        Gson gson = new Gson();
        boolean found = false;
        try {
            FileWriter fileWriter = new FileWriter(BOOK_JSON_FILE, true);

            if (file.length() == 0) {
                System.out.println("There are no books in this file.");
                fileWriter.close();
            }
            else {
                Reader reader = new FileReader(BOOK_JSON_FILE);
                JsonArray jsonArray = (JsonArray) jsonParser.parse(reader);

                Type listType = new TypeToken<ArrayList<Book>>() {
                }.getType();
                List<Book> bookList = new Gson().fromJson(jsonArray, listType);

                try {
                    for (Book bm : bookList) {
//                    if ((!(BookValidateView.validateThirteenDigitISBNNumber(isbnInput))) || (!(BookValidateView.validateTenDigitISBNNumber(isbnInput)))){
//                        System.out.println("\nThe input is invalid ISBN number formatting.");
//                    }
                        if ((!(BookValidateView.validateTenDigitISBNNumber(isbnInput))) && (!(BookValidateView.validateThirteenDigitISBNNumber(isbnInput)))) {
                            throw new IsbnException("The input is improperly formatted for an isbn number.");
                        }
                        if ((bm.getTenDigitISBN().equals(isbnInput)) || (bm.getThirteenDigitISBN().equals(isbnInput))) {
                            System.out.println("\nThe book with the isbn number \"" + isbnInput + "\" has been found:");
                            System.out.println(bm.toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nThe book with the isbn number \"" + isbnInput + "\" was not found.");
                    }
                } catch (IsbnException isbnException) {
                    System.out.println(isbnException.getMessage().toString());
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage().toString());
        }
        return found;
    }
}
