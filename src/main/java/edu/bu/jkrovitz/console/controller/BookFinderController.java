package edu.bu.jkrovitz.console.controller;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import edu.bu.jkrovitz.console.model.BookModel;
import edu.bu.jkrovitz.console.view.books.BookFinderView;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BookFinderController {
    BookFinderView bookFinderView = new BookFinderView();
    BookModel bookModel = new BookModel();

    public void findBook() {
        System.out.println();
        String bookTitle = bookFinderView.findBookByTitle();
        String bookAuthor = " " + bookFinderView.findBookByAuthor();
        boolean found = false;
        try (CSVReader reader = new CSVReader(new FileReader(bookModel.getBookFile()))) {
            List<String[]> r = reader.readAll();

            String[] headers = r.get(0);
            int getTitleIndex = Arrays.asList(r.get(0)).indexOf("Book Title");
            int getAuthorIndex = Arrays.asList(r.get(0)).indexOf(" Book Author(s)");
            for (int i = 1; i < r.size(); i++) {
                String[] strings = r.get(i);
                String[] lastLine = r.get(r.size()-1);
                if ((strings[0].equals(bookTitle)) && (strings[1].equals(bookAuthor))) {
                    System.out.println("The following book was found:");
                    System.out.println(Arrays.toString(headers));
                    System.out.println(Arrays.toString(strings));
                    found = true;
                }
            }
            if (!found){
                System.out.println("The book was not found");
            }
            System.out.println();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
