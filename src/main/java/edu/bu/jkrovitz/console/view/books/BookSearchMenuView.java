package edu.bu.jkrovitz.console.view.books;

import edu.bu.jkrovitz.console.controller.books.BookFinderController;

import java.util.Scanner;

/**
 * Class allows any of the roles in the library to search for a book by author and title or ISBN number.
 *
 * @author Jeremy Krovitz
 */
public class BookSearchMenuView {

    public void chooseBookSearchMethod(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go Back 2. Search by title and author 3. Search by ISBN");
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
                    break;
                case 2:
                    BookFinderController titleAndAuthorSearch = new BookFinderController();
                    titleAndAuthorSearch.findBookByTitleAndAuthor();
                    break;
                case 3:
                    BookFinderController isbnSearch = new BookFinderController();
                    isbnSearch.findBookByTenOrThirteenDigitIsbn();
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }
        } while (choice != 1);
    }
}
