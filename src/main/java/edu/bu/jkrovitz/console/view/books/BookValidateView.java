package edu.bu.jkrovitz.console.view.books;

/**
 * Validates various book attributes.
 *
 * @author Jeremy Krovitz
 */
public class BookValidateView {

    public static boolean validateBookTitle(String title) {
        return title.matches("^\\w++(?:[.,_:()\\s-](?![.\\s-])|\\w++)*$");
    }

    public static boolean validateAuthor(String author) {
        return author.matches("[a-zA-Z]*[\\s]{1}[a-zA-Z].*");
    }

    public static boolean validateYear(int year) {
        return String.valueOf(year).matches("\\d{4}");
    }

    public static boolean validatePublisher(String publisher) {
        return publisher.matches("^\\w++(?:[.,_:()\\s-](?![.\\s-])|\\w++)*$");
    }

    public static boolean validatePages(int pages) {
        return String.valueOf(pages).matches("\\d{1,5}"); // Number of pages can go up to 5 digits based off some of the largest books in the world: https://forreadingaddicts.co.uk/news/ten-of-the-worlds-longest-books/
    }

    public static boolean validateThirteenDigitISBNNumber(String thirteenDigitISBN) {
        return thirteenDigitISBN.matches("^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$"); // Obtained and modified regex from https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/
    }

    public static boolean validateTenDigitISBNNumber(String tenDigitISBN) {
        return tenDigitISBN.matches("^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$"); // Obtained and modified regex from https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/
    }

    public static boolean validateCopies(int copies) {
        return String.valueOf(copies).matches("[1-9]|10");
    }

    public static boolean validateQuantityAvailable(int quantityAvailable) {
        return String.valueOf(quantityAvailable).matches("[1-9]|10");
    }

    /**
     * This method defines the class invariant because
     * it verifies that all fields of a BookView instance
     * take acceptable values.
     *
     */
    public void validateState(String title, String author, int yearPublished, String publisher, int pages, String briefDescription, String thirteenDigitISBN, String tenDigitISBN, int copies, int quantityAvailable){
        validateBookTitle(title);
        validateAuthor(author);
        validateYear(yearPublished);
        validatePublisher(publisher);
        validatePages(pages);
//        validateBriefDescription(briefDescription);
        validateThirteenDigitISBNNumber(thirteenDigitISBN);
        validateTenDigitISBNNumber(tenDigitISBN);
        validateCopies(copies);
        validateQuantityAvailable(quantityAvailable);
    }
}
