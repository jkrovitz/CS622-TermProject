package edu.bu.jkrovitz.console.model.books;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for methods in the Book class.
 */
class BookTest {

    private Book book = null;

    @BeforeEach
    void setUp() {
        book = new Book();
        book.setTitle("The Great Gatsby");
        book.setAuthor("F. Scott Fitzgerald");
        book.setYear(2021);
        book.setPublisher("Independently published");
        book.setPages(123);
        book.setBriefDescription("The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, the novel depicts narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby, and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.");
        book.setThirteenDigitISBN("979-8-581-48423-4");
        book.setTenDigitISBN("8-581-48423-4");
        book.setCopies(1);
        book.setQuantityAvailable(1);
    }

    @Test
    void getTitle() {
        String expResult = "The Great Gatsby";
        assertEquals(expResult, book.getTitle());
    }

    @Test
    void setTitle() {
        String expResult = "To Kill A Mockingbird";
        book.setTitle("To Kill A Mockingbird");
        assertEquals(expResult, book.getTitle());
    }

    @Test
    void getAuthor() {
        String expResult = "F. Scott Fitzgerald";
        assertEquals(expResult, book.getAuthor());
    }

    @Test
    void setAuthor() {
        String expResult = "Harper Lee";
        book.setAuthor("Harper Lee");
        assertEquals(expResult, book.getAuthor());
    }

    @Test
    void getYear() {
        int expResult = 2021;
        assertEquals(expResult, book.getYear());
    }

    @Test
    void setYear() {
        int expResult = 1988;
        book.setYear(1988);
        assertEquals(expResult, book.getYear());
    }

    @Test
    void getPublisher() {
        String expResult = "Independently published";
        assertEquals(expResult, book.getPublisher());
    }

    @Test
    void setPublisher() {
        String expResult = "Grand Central Publishing";
        book.setPublisher("Grand Central Publishing");
        assertEquals(expResult, book.getPublisher());
    }

    @Test
    void getPages() {
        int expResult = 123;
        assertEquals(expResult, book.getPages());
    }

    @Test
    void setPages() {
        int expResult = 384;
        book.setPages(384);
        assertEquals(expResult, book.getPages());
    }

    @Test
    void getBriefDescription() {
        String expResult = "The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, the novel depicts narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby, and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.";
        assertEquals(expResult, book.getBriefDescription());
    }

    @Test
    void setBriefDescription() {
        String expResult = "The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it, To Kill A Mockingbird became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.";
        book.setBriefDescription("The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it, To Kill A Mockingbird became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.");
        assertEquals(expResult, book.getBriefDescription());
    }

    @Test
    void getThirteenDigitISBN() {
        String expResult = "979-8-581-48423-4";
        assertEquals(expResult, book.getThirteenDigitISBN());
    }

    @Test
    void setThirteenDigitISBN() {
        String expResult = "978-0-446-31078-9";
        book.setThirteenDigitISBN("978-0-446-31078-9");
        assertEquals(expResult, book.getThirteenDigitISBN());
    }

    @Test
    void getTenDigitISBN() {
        String expResult = "8-581-48423-4";
        assertEquals(expResult, book.getTenDigitISBN());
    }

    @Test
    void setTenDigitISBN() {
        String expResult = "0-446-31078-6";
        book.setTenDigitISBN("0-446-31078-6");
        assertEquals(expResult, book.getTenDigitISBN());
    }

    @Test
    void getCopies() {
        int expResult = 1;
        assertEquals(expResult, book.getCopies());
    }

    @Test
    void setCopies() {
        int expResult = 2;
        book.setCopies(2);
        assertEquals(expResult, book.getCopies());
    }

    @Test
    void getQuantityAvailable() {
        int expResult = 1;
        assertEquals(expResult, book.getQuantityAvailable());
    }

    @Test
    void setQuantityAvailable() {
        int expResult = 2;
        book.setQuantityAvailable(2);
        assertEquals(expResult, book.getQuantityAvailable());
    }

    @Test
    void testToString() {
        String expResult = "Book [\n    title: " + book.getTitle() + ",\n    author: " + book.getAuthor() + ",\n    year: " + book.getYear() + ",\n    publisher: " + book.getPublisher() + ",\n    pages: " + book.getPages() + ",\n    brief description: " + book.getBriefDescription() + ",\n    thirteen digit ISBN: " + book.getThirteenDigitISBN() + ",\n    ten digit ISBN: " + book.getTenDigitISBN() + ",\n    copies: " + book.getCopies() + ",\n    quantity available: " + book.getQuantityAvailable() + "\n]\n\n";
        assertEquals(expResult, book.toString());
    }

    @AfterEach
    void tearDown() {
        book = null;
    }
}