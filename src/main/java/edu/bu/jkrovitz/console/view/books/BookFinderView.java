package edu.bu.jkrovitz.console.view.books;

import java.util.Scanner;

/**
 * Class contains methods asking the user to input various attributes for a book they are looking for.
 *
 * @author Jeremy Krovitz
 */
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

    public String findBookByTenOrThirteenDigitISBNNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ISBN number of the book you're looking for.");
        return scanner.nextLine();
    }
}
