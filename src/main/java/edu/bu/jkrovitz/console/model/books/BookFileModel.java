package edu.bu.jkrovitz.console.model.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVWriter;

import java.io.*;
import java.lang.reflect.Array;
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
    private static final String BOOK_CSV_FILE = "./src/main/resources/edu.bu.jkrovitz/csvs/books.csv";
    private static final String BOOK_JSON_FILE = "./src/main/resources/edu.bu.jkrovitz.json/books.json";

    public String addToBookFile(String fileString, String title, String author, int year, String publisher, int pages, String briefDescription, String thirteenDigitIsbn, String tenDigitIsbn, int copies, int quantityAvailable) {
        Gson gson = null;
        File file = new File(fileString);
        String jsonString = "";
        try (FileWriter fileWriter = new FileWriter(fileString, true)) {
            gson = new Gson();
            if (file.length() == 0) {
                Book book = new Book(title, author, year, publisher, pages, briefDescription, thirteenDigitIsbn, tenDigitIsbn, copies, quantityAvailable);
                gson = addBookToEmptyFile(gson, book, fileWriter);
                jsonString = gson.toJson(book);
            } else {
                Book book = new Book(title, author, year, publisher, pages, briefDescription, thirteenDigitIsbn, tenDigitIsbn, copies, quantityAvailable);
                gson = addBookToNonEmptyFile(fileString, gson, book, fileWriter);
                jsonString = gson.toJson(book);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(jsonString);
        return jsonString;
    }

    public static String[] writeBookCsvData(String title, String author, int year, String publisher, int pages, String briefDescription, String thirteenDigitIsbn, String tenDigitIsbn, int copies, int quantityAvailable)
    {
        // first create file object for file placed at location
        // specified by filepath
        String[] bookData = null;
        File file = new File(BOOK_CSV_FILE);
        try (FileWriter outputfile = new FileWriter(file, true)){

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            if (file.length() == 0) {
                // adding header to csv
                String[] header = {"title", "author", "year", "publisher", "pages", "brief description", "isbn-13", "isbn-10", "copies", "quanity available"};
                writer.writeNext(header);
            }

//            // add data to csv
//            String[] data1 = { "Aman", "10", "620" };
//            writer.writeNext(data1);
//            String[] data2 = { "Suraj", "10", "630" };
//            writer.writeNext(data2);

            bookData = new String[]{title, author, String.valueOf(year), publisher, String.valueOf(pages), briefDescription, thirteenDigitIsbn, tenDigitIsbn, String.valueOf(copies), String.valueOf(quantityAvailable)};
            writer.writeNext(bookData);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bookData;
    }

    public Gson addBookToEmptyFile(Gson gson, Book book, FileWriter fileWriter){
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        gson.toJson(bookList, fileWriter);
        System.out.println(gson);
        return gson;
    }

    public Gson addBookToNonEmptyFile(String fileString, Gson gson, Book book, FileWriter fileWriter){
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(fileString));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Book> bookList = new Gson().fromJson(reader, new TypeToken<List<Book>>() {
        }.getType());
        try {
            PrintWriter writer = new PrintWriter(fileString);
            writer.print("");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (!bookList.isEmpty()) {
            bookList.add(book);
            gson.toJson(bookList, fileWriter);
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return gson;
    }

    public String getBookFile() {
        return BOOK_JSON_FILE;
    }

}
