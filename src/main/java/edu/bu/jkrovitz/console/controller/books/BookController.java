package edu.bu.jkrovitz.console.controller.books;

import edu.bu.jkrovitz.console.model.books.*;
import edu.bu.jkrovitz.console.view.books.BookFinderView;
import edu.bu.jkrovitz.console.view.books.BookView;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void addOrUpdateBook(Book book) throws SQLException {
        UpdateCopiesAndQuantityAvailable updateCopiesAndQuantityAvailable = new UpdateCopiesAndQuantityAvailable();
        SearchBook searchBook = new SearchBook();
        ArrayList<ArrayList<String>> books = searchBook.selectBooks();
        ArrayList<String> thirteenDigitIsbnNumbers = books.get(0);
        ArrayList<String> tenDigitIsbnNumbers = books.get(1);

        String thirteenDigitIsbnNumberInput = book.getThirteenDigitISBN();
        String tenDigitIsbnNumberInput = book.getTenDigitISBN();

        if ((thirteenDigitIsbnNumbers.contains(thirteenDigitIsbnNumberInput))){
            ArrayList<Integer> quantitiesAndCopies = searchBook.selectQuantityAndCopies("thirteen_digit_isbn_number", thirteenDigitIsbnNumberInput);
            int quantityAvailable = quantitiesAndCopies.get(0);
            int copies = quantitiesAndCopies.get(1);

            int inputQuantity = book.getQuantityAvailable();
            int inputCopies = book.getCopies();

            copies = copies + inputQuantity;
            quantityAvailable = quantityAvailable + inputCopies;
            updateCopiesAndQuantityAvailable.updateForThirteenDigitIsbn(copies, quantityAvailable, thirteenDigitIsbnNumberInput);
        }
        else if (tenDigitIsbnNumbers.contains(tenDigitIsbnNumberInput)){
            ArrayList<Integer> quantitiesAndCopies = searchBook.selectQuantityAndCopies("ten_digit_isbn_number", tenDigitIsbnNumberInput);
            int quantityAvailable = quantitiesAndCopies.get(0);
            int copies = quantitiesAndCopies.get(1);

            int inputQuantity = book.getQuantityAvailable();
            int inputCopies = book.getCopies();

            copies = copies + inputQuantity;
            quantityAvailable = quantityAvailable + inputCopies;
            updateCopiesAndQuantityAvailable.updateForTenDigitIsbn(copies, quantityAvailable, tenDigitIsbnNumberInput);
        }
        else {
            int bookId = insertBook(book);
            insertAuthor(book, bookId);
        }
    }

    public int insertBook(Book book) throws SQLException {
        return bookModel.addBook(
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
    }

    public void insertAuthor(Book book, int bookId) throws SQLException {
        int authorId = 0;
        String authorFromInput = book.getAuthor();
        AuthorStringManipulation authorStringManipulation = new AuthorStringManipulation();
        String[] authorArray = authorStringManipulation.createAuthorArray(authorFromInput);
        SearchAuthor searchAuthor = new SearchAuthor();
        if (searchAuthor.authorCountGreaterThanZero()){
            authorId = searchAuthor.getAuthorId(authorArray);
            if (authorId > 0){
                bookAuthorModel.addBookAuthor(bookId, authorId);
            }
            else {
                addToAuthorTableAndBookAuthorTable(bookId, authorId);
            }
        }
        else {
            addToAuthorTableAndBookAuthorTable(bookId, authorId);
        }
    }

    private void addToAuthorTableAndBookAuthorTable(int bookId, int authorId) throws SQLException {
        authorId = authorModel.addAuthor(
                book.getAuthor()
        );
        if (authorId > 0) {
            bookAuthorModel.addBookAuthor(bookId, authorId);
        }
    }

    public void processOutput() throws IOException, ParseException, SQLException {
        setBookInformation();
        addOrUpdateBook(book);
    }
}
