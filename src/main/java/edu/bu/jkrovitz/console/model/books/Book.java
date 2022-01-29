package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.exceptions.book.IsbnException;

/**
 * The class Book sets/gets the various attributes of a book.
 *
 * @author Jeremy Krovitz
 */
public class Book extends IsbnException {

    private String title;
    private String author;
    private int year;
    private String publisher;
    private int pages;
    private String briefDescription;
    private String thirteenDigitISBN;
    private String tenDigitISBN;
    private int copies;
    private int quantityAvailable;

    public Book() {
    }

    public Book(String title, String author, int year, String publisher, int pages, String briefDescription, String thirteenDigitISBN, String tenDigitISBN, int copies, int quantityAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
        this.briefDescription = briefDescription;
        this.thirteenDigitISBN = thirteenDigitISBN;
        this.tenDigitISBN = tenDigitISBN;
        this.copies = copies;
        this.quantityAvailable = quantityAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getThirteenDigitISBN() {
        return thirteenDigitISBN;
    }

    public void setThirteenDigitISBN(String thirteenDigitISBN) {
        this.thirteenDigitISBN = thirteenDigitISBN;
    }

    public String getTenDigitISBN() {
        return tenDigitISBN;
    }

    public void setTenDigitISBN(String tenDigitISBN) {
        this.tenDigitISBN = tenDigitISBN;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String toString() {
        return String.format("Book [%n    title: %s,%n    author: %s,%n    year: %d,%n    publisher: %s,%n    " + "pages: %d,%n    brief description: %s,%n    thirteen digit ISBN: %s,%n    ten digit ISBN: %s,%n" + "    copies: %d,%n    quantity available: %d%n]%n%n", title, author, year, publisher, pages, briefDescription, thirteenDigitISBN, tenDigitISBN, copies, quantityAvailable);
    }
}
