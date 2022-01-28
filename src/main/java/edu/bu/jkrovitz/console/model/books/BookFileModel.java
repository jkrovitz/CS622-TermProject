package edu.bu.jkrovitz.console.model.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The class adds books to a JSON file.
 *
 * @author Jeremy Krovitz
 */
public class BookFileModel {
    private static final String BOOK_JSON_FILE = "./src/main/resources/edu.bu.jkrovitz.json/books.json";

    public void addToBookFile(String title, String author, int year, String publisher, int pages, String briefDescription, String thirteenDigitIsbn, String tenDigitIsbn, int copies, int quantityAvailable) {
        File file = new File(BOOK_JSON_FILE);
        try (FileWriter fileWriter = new FileWriter(BOOK_JSON_FILE, true)) {
            Gson gson = new Gson();
            if (file.length() == 0) {
                List<Book> bookList = new ArrayList<>();
                bookList.add(new Book(title, author, year, publisher, pages, briefDescription, thirteenDigitIsbn, tenDigitIsbn, copies, quantityAvailable));
                gson.toJson(bookList, fileWriter);
                fileWriter.close();
            } else {
                Reader reader = Files.newBufferedReader(Paths.get(BOOK_JSON_FILE));
                List<Book> bookList = new Gson().fromJson(reader, new TypeToken<List<Book>>() {
                }.getType());
                PrintWriter writer = new PrintWriter(BOOK_JSON_FILE);
                writer.print("");

                if (!bookList.isEmpty()) {
                    bookList.add(new Book(title, author, year, publisher, pages, briefDescription, thirteenDigitIsbn, tenDigitIsbn, copies, quantityAvailable));
                    gson.toJson(bookList, fileWriter);
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getBookFile() {
        return BOOK_JSON_FILE;
    }

}
