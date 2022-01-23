package edu.bu.jkrovitz.console.view.books;

import java.util.Scanner;

public class BookFinderView {

    public String findBookByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the book you're looking for.");
        return scanner.nextLine();
    }

    public String findBookByAuthor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the author of the book you're looking for.");
        return scanner.nextLine();
    }
}
