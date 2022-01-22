package edu.bu.jkrovitz.console.view;

import java.util.Scanner;

public class BookView {

    public String askTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the title of the book?");
        return scanner.nextLine();
    }

    public String askAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who is the author of the book? Separate multiple authors with semicolons.");
        return scanner.nextLine();
    }

    public int askYearPublished() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What year was the book published?");
        return scanner.nextInt();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the 13 digit isbn number for the book.");
        return scanner.nextLine();
    }

    public String askTenDigitIsbn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the book's 10 digit isbn number.");
        return scanner.nextLine();
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
