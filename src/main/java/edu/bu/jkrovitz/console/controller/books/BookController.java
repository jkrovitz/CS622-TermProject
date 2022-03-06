package edu.bu.jkrovitz.console.controller.books;

import edu.bu.jkrovitz.console.model.books.*;
import edu.bu.jkrovitz.console.view.books.BookFinderView;
import edu.bu.jkrovitz.console.view.books.BookView;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Class handles getting information about a book from the view, sets the information about the book, and
 * saves it to a file.
 *
 * @author Jeremy Krovitz
 */
public class BookController {
    BookView<java.io.Serializable> view = new BookView<java.io.Serializable>();
    Book book = new Book();
    BookModel bookModel = new BookModel();
    AuthorModel authorModel = new AuthorModel();
    BookAuthorModel bookAuthorModel = new BookAuthorModel();
    BookFileModel bookFileModel = new BookFileModel();
    BookFinderView bookFinderView = new BookFinderView();
    private static final String BOOK_JSON_FILE = "./src/main/resources/edu.bu.jkrovitz.json/books.json";

    public void setBookInformation() {
        book.setTitle((view.askTitle()));
        book.setAuthor(view.askAuthor());
        book.setYear(view.askYearPublished());
        book.setPublisher(view.askPublisher());
        book.setPages(view.askPages());
        book.setBriefDescription(view.askBriefDescription());
        book.setThirteenDigitISBN(view.askThirteenDigitIsbn());
        book.setTenDigitISBN(view.askTenDigitIsbn());
        book.setCopies(view.askCopies());
        book.setQuantityAvailable(view.askQuantityAvailable());
    }

    public void outputBooksToFile() throws IOException, ParseException {
        BookFileModel bookFileModel = new BookFileModel();
        bookFileModel.addToBookFile(BOOK_JSON_FILE, book.getTitle(), book.getAuthor(), book.getYear(), book.getPublisher(), book.getPages(), book.getBriefDescription(), book.getThirteenDigitISBN(), book.getTenDigitISBN(), book.getCopies(), book.getQuantityAvailable());
    }

//    public void bookModel(Book book) throws SQLException{
//        bookModel.addBook(
//                book.getTitle(),
//                book.getYear(),
//                book.getPublisher(),
//                book.getPages(),
//                book.getBriefDescription(),
//                book.getThirteenDigitISBN(),
//                book.getTenDigitISBN(),
//                book.getQuantityAvailable(),
//                book.getCopies()
//        );
//    }
//
//    public void authorModel(Book book) throws SQLException{
//        authorModel.addAuthor(
//              book.getAuthor()
//        );
//    }

    public void insertBook(Book book) throws SQLException {
        int bookId = bookModel.addBook(
                book.getTitle(),
                book.getYear(),
                book.getPublisher(),
                book.getPages(),
                book.getBriefDescription(),
                book.getThirteenDigitISBN(),
                book.getTenDigitISBN(),
                book.getQuantityAvailable(),
                book.getCopies()
        );
        int authorId = authorModel.addAuthor(
              book.getAuthor()
        );
        bookAuthorModel.addBookAuthor(bookId, authorId);

    }

    public void processOutput() throws IOException, ParseException, SQLException {
        setBookInformation();
        insertBook(book);
    }
}
