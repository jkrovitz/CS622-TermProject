package edu.bu.jkrovitz.console.model;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookModel {

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

    public void outputBooksToFile(String title, String author, int year, String publisher, int pages, String briefDescription, String thirteenDigitIsbn, String tenDigitIsbn, int copies, int quantityAvailable) {
        Path root = Paths.get(".").normalize().toAbsolutePath();
        String bookFile = root + "/src/main/java/edu/bu/jkrovitz/console/model/csvs/booklist.csv";
        String[] columnHeaders = {"Book Title", "Book Author(s)", "Year Published", "Publisher", "Pages", "Brief Description", "13 Digit ISBN", "10 Digit ISBN", "Copies", "Available"};
        try {
            FileWriter csvWriter = new FileWriter(bookFile, true);
            File file = new File(bookFile);

            if (file.length() == 0) {

                for (String columnHeader : columnHeaders) {
                    csvWriter.append(columnHeader + ", ");
                }
            }
            csvWriter.append("\n" + title + ", " + author + ", " + year + ", " + publisher + ", " + pages + ", " + briefDescription + "," + thirteenDigitIsbn + ", " + tenDigitIsbn + ", " + copies + ", " + quantityAvailable);
            csvWriter.close();
        } catch (Exception e) {
            System.out.println("exception :" + e.getMessage());
        }
    }
}
