package edu.bu.jkrovitz.console.view.roles.patron;

import edu.bu.jkrovitz.console.controller.books.BookFinderController;

import java.util.Scanner;

/**
 *  Displays a menu after the patron is logged in with a variety of choices they can make.
 * @author Jeremy Krovitz
 */
public class PatronMenuView {

    public void patronMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Search for a book 2. Go back to the main menu");
                if (sc.hasNextInt()) {
                    break;
                }
                String input = String.valueOf(sc.next());
                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    BookFinderController bookControllerFinder = new BookFinderController();
                    bookControllerFinder.findBookByTitleAndAuthor();
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }
        } while (!(choice == 2));
    }
}
