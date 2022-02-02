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
public class BookView<T> {

    private static final Logger logger = LogManager.getLogger(BookView.class);
    private String title;
    private String author;
    private int yearPublished;
    private String publisher;
    private int pages;
    private String briefDescription;
    private String thirteenDigitISBN;
    private String tenDigitISBN;
    private int copies;
    private int quantityAvailable;

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

            } catch (BookException titleException) {

                logger.info(titleException.getMessage());
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
            } catch (BookException authorException) {
                logger.error(authorException.getMessage());
            }
        } while (!matches);
        return author;
    }

    public int askYearPublished() {
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("What year was the book published?");
                yearPublished = scanner.nextInt();
                if (!(BookValidateView.validateYear(yearPublished))) {
                    throw (new BookException(("Please correct the year formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException yearException) {
                logger.error(yearException.getMessage());
            }
        } while (!matches);
        return yearPublished;
    }

    public String askPublisher() {
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Who is the publisher?");
                publisher = scanner.nextLine();
                if (!(BookValidateView.validatePublisher(publisher))) {
                    throw (new BookException(("Please correct the publisher formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException publisher) {
                logger.error(publisher.getMessage());
            }
        } while (!matches);
        
        return publisher;
    }

    public int askPages() {
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("How many pages does the book have?");
                pages = scanner.nextInt();
                if (!(BookValidateView.validatePages(pages))) {
                    throw (new BookException(("Please correct the page formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException pagesException) {
                logger.error(pagesException.getMessage());
            }
        } while (!matches);
        return pages;
    }
    

    public String askBriefDescription() {
        boolean matches = false;
        do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please provide a brief description of the book?");
                StringBuilder briefDescriptionBuilder = new StringBuilder(scanner.nextLine());
                briefDescription = scanner.nextLine();
                    matches = true;
                    while (true) {
                        System.out.println("Would you like to provide an additional line for the brief description? Press \"n\" for no or any other key for yes.");
                        if (scanner.nextLine().equals("n")) {
                            break;
                        } else {
                            System.out.println("Please enter the next line of your description.");
                            briefDescriptionBuilder.append(" " + scanner.nextLine());
                        }
                }
                briefDescription = briefDescriptionBuilder.toString();
        } while (!matches);

        return briefDescription;
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
        assert BookValidateView.validateThirteenDigitISBNNumber(thirteenDigitISBN);
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
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("How many copies do you have??");
                copies = scanner.nextInt();
                if (!(BookValidateView.validateCopies(copies))) {
                    throw (new BookException(("Please correct the copies formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException copiesException) {
                logger.error(copiesException.getMessage());
            }
        } while (!matches);
        return copies;
    }

    public int askQuantityAvailable() {
        boolean matches = false;
        do {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("How many do you have available?");
                quantityAvailable = scanner.nextInt();
                if (!(BookValidateView.validateQuantityAvailable(quantityAvailable))) {
                    throw (new BookException(("Please correct the quantity formatting.")));
                } else {
                    matches = true;
                }
            } catch (BookException quantityException) {
                logger.error(quantityException.getMessage());
            }
        } while (!matches);
        return quantityAvailable;
    }

    public T ask(T t) {
        return t;
    }
}
