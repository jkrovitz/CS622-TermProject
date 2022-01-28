package edu.bu.jkrovitz.console.controller.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.bu.jkrovitz.console.model.books.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The class BookFinderList handles displaying all books in the system.
 *
 * @author Jeremy Krovitz
 */
public class BookListController extends BookFinderController {
    private static final String BOOK_JSON_FILE = "./src/main/resources/edu.bu.jkrovitz.json/books.json";

    public List<Book> getBookList() {
        List<Book> bookList = null;
        File file = new File(BOOK_JSON_FILE);
        try (FileWriter fileWriter = new FileWriter(BOOK_JSON_FILE, true)) {
            if (file.length() == 0) {
                System.out.println("There are no books in this file.");
                fileWriter.close();
            } else {
                Reader reader = Files.newBufferedReader(Paths.get(BOOK_JSON_FILE));
                bookList = new Gson().fromJson(reader, new TypeToken<List<Book>>() {
                }.getType());
                for (Book bm : bookList) {
                    System.out.println(bm.toString());
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bookList;
    }
}
