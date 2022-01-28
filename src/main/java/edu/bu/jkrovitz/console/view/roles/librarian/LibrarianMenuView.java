package edu.bu.jkrovitz.console.view.roles.librarian;

import edu.bu.jkrovitz.console.controller.books.BookController;
import edu.bu.jkrovitz.console.controller.books.BookFinderController;
import edu.bu.jkrovitz.console.controller.books.BookListController;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

/**
 *  Displays a menu after the librarian is logged in with a variety of choices they can make.
 * @author Jeremy Krovitz
 */
public class LibrarianMenuView {

    public void librarianMenu() throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go Back 2. Add a new book? 3. Search 4. View list of all book information");
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
                    BookController bookController = new BookController();
                    bookController.processOutput();
                    break;
                case 3:
                    chooseBookSearchMethod();
                    break;
                case 4:
                    BookListController bookListController = new BookListController();
                    bookListController.getBookList();
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }
        } while (choice != 1);
    }

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