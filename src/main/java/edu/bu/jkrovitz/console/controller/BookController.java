package edu.bu.jkrovitz.console.controller;

import edu.bu.jkrovitz.console.model.BookModel;
import edu.bu.jkrovitz.console.view.books.BookFinderView;
import edu.bu.jkrovitz.console.view.books.BookView;

public class BookController {
    BookView view = new BookView();
    BookModel model = new BookModel();
    BookFinderView bookFinderView = new BookFinderView();

    public void setBookInformation() {
        model.setTitle(view.askTitle());
        model.setAuthor(view.askAuthor());
        model.setYear(view.askYearPublished());
        model.setPublisher(view.askPublisher());
        model.setPages(view.askPages());
        model.setBriefDescription(view.askBriefDescription());
        model.setThirteenDigitISBN(view.askThirteenDigitIsbn());
        model.setTenDigitISBN(view.askTenDigitIsbn());
        model.setCopies(view.askCopies());
        model.setQuantityAvailable(view.askQuantityAvailable());
    }

    public void outputBooksToFile() {
        model.outputBooksToFile(model.getTitle(), model.getAuthor(), model.getYear(), model.getPublisher(), model.getPages(), model.getBriefDescription(), model.getThirteenDigitISBN(), model.getTenDigitISBN(), model.getCopies(), model.getQuantityAvailable());
    }

    public void processOutput() {
        setBookInformation();
        outputBooksToFile();
    }
}
