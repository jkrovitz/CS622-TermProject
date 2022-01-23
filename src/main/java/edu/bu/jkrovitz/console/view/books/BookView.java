package edu.bu.jkrovitz.console.view.books;

import java.awt.print.Book;
import java.util.Scanner;

public class BookView {

    private String title;
    private int yearPublished;
    private String thirteenDigitISBN;
    private String tenDigitISBN;


    public String askTitle(){
        boolean matches = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the title of the book?");
            title = scanner.nextLine();
            if (!(BookValidateView.validateBookTitle(title))) {
                System.out.println("Please correct the title formatting.");
            }
            else{
                matches = true;
            }
        } while (!matches);
        return title;
    }

    public String askAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who is the author of the book? Separate multiple authors with semicolons.");
        return scanner.nextLine();
    }

    public int askYearPublished() {
        boolean matches = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What year was the book published?");
            yearPublished = scanner.nextInt();
            if (!(BookValidateView.validateYear(yearPublished))) {
                System.out.println("Please correct the year formatting.");
            }
            else{
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

    public int askPages(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pages long is the book?");
        return scanner.nextInt();
    }

    public String askBriefDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a brief description of the book?");
        return scanner.nextLine();
    }

    public String askThirteenDigitIsbn() {
        boolean matches = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please provide the 13 digit isbn number for the book.");
            thirteenDigitISBN = scanner.nextLine();
            if (!(BookValidateView.validateThirteenDigitISBNNumber(thirteenDigitISBN))) {
               System.out.println("Please correct the ISBN formatting.");
            }
            else{
                matches = true;
            }
        } while (!matches);
        return thirteenDigitISBN;
    }

    public String askTenDigitIsbn() {
        boolean matches = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input the book's 10 digit isbn number.");
            tenDigitISBN = scanner.nextLine();
            if (!(BookValidateView.validateTenDigitISBNNumber(tenDigitISBN))) {
                System.out.println("Please correct the ISBN formatting.");
            } else {
                matches = true;
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
