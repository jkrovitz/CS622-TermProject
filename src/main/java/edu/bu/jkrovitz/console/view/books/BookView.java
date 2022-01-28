package edu.bu.jkrovitz.console.view.books;

import edu.bu.jkrovitz.console.exceptions.book.BookException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Asks the user to enter attributes of a book.
 *
 * @author Jeremy Krovitz
 */
public class BookView {

    private static final Logger logger = LogManager.getLogger(BookView.class);
    private String title;
    private String author;
    private int yearPublished;
    private String thirteenDigitISBN;
    private String tenDigitISBN;

    public String askTitle() {
        boolean matches = false;
        do {
            title = null;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the title of the book?");
                title = scanner.nextLine();
                if (!(BookValidateView.validateBookTitle(title))) {
                    throw (new BookException("Please correct the title formatting."));
                } else {
                    matches = true;
                }

            } catch (BookException bookException) {

                logger.info(bookException.getMessage());
            }
        } while (!matches);
        return title;
    }

    public String askAuthor() {
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Who is the author?");
                author = scanner.nextLine();
                if (!(BookValidateView.validateAuthor(author))) {
                    throw (new BookException(("Please correct the author formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException author) {
                logger.error(author.getMessage());
            }
        } while (!matches);
        return author;
    }

    public int askYearPublished() {
        boolean matches = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What year was the book published?");
            yearPublished = scanner.nextInt();
            if (!(BookValidateView.validateYear(yearPublished))) {
                System.out.println("Please correct the year formatting.");
            } else {
                matches = true;
            }
        } while (!matches);
        return yearPublished;
    }

    public String askPublisher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who was the book's publisher?");
        return scanner.nextLine();
    }

    public int askPages() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pages long is the book?");
        return scanner.nextInt();
    }

    public String askBriefDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a brief description of the book?");
        StringBuilder briefDescription = new StringBuilder(scanner.nextLine());
        while (true) {
            System.out.println("Would you like to provide an additional line for the brief description? Press \"n\" for no or any other key for yes.");
            if (scanner.nextLine().equals("n")) {
                break;
            } else {
                System.out.println("Please enter the next line of your description.");
                briefDescription.append(" " + scanner.nextLine());
            }
        }
        return briefDescription.toString();
    }

    public String askThirteenDigitIsbn() {
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Please provide the 13 digit isbn number for the book.");
                thirteenDigitISBN = scanner.nextLine();
                if (!(BookValidateView.validateThirteenDigitISBNNumber(thirteenDigitISBN))) {
                    throw (new BookException(("Please correct the ISBN formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException thirteenDigitIsbnException) {
                logger.error(thirteenDigitIsbnException.getMessage());
            }
        } while (!matches);
        return thirteenDigitISBN;
    }

    public String askTenDigitIsbn() {
        boolean matches = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please input the book's 10 digit isbn number.");
                tenDigitISBN = scanner.nextLine();
                if (!(BookValidateView.validateTenDigitISBNNumber(tenDigitISBN))) {
                    throw (new BookException(("Please correct the ISBN formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException tenDigitIsbnException) {
                logger.error(tenDigitIsbnException.getMessage());
            }
        }
        while (!matches);
        return tenDigitISBN;
    }

    public int askCopies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of copies of this book that the library has.");
        return scanner.nextInt();
    }

    public int askQuantityAvailable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the quantity of books available (the number that are not checked out). ");
        return scanner.nextInt();
    }
}
