package edu.bu.jkrovitz.console.view.roles.admin;

import edu.bu.jkrovitz.console.controller.books.BookController;
import edu.bu.jkrovitz.console.controller.books.BookListController;
import edu.bu.jkrovitz.console.controller.roles.LibrarianController;
import edu.bu.jkrovitz.console.controller.roles.LibraryClerkController;
import edu.bu.jkrovitz.console.controller.roles.LibraryUserController;
import edu.bu.jkrovitz.console.controller.roles.PatronController;
import edu.bu.jkrovitz.console.view.books.BookSearchMenuView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The class prints the prompts for the admin that they respond to when they try to login.
 *
 * @author Jeremy Krovitz
 */
public class AdminMenuView {

    public void adminMenu() throws SQLException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;

            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Add a new book? 3. Add a new Librarian? 4.View list of all book information 5. Search for a book 6. Register User 7. Register Checkout Clerk");
                if (sc.hasNextInt()) {
                    break;
                }
                String input = String.valueOf(sc.next());
                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }

            if (sc.hasNextInt()) {
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
                        LibraryUserController librarian = new LibrarianController();
                        librarian.registerUser();
                        break;
                    case 4:
                        BookListController bookListController = new BookListController();
                        bookListController.getBookList();
                        break;
                    case 5:
                        BookSearchMenuView bookSearchMenuView = new BookSearchMenuView();
                        bookSearchMenuView.chooseBookSearchMethod();
                        break;
                    case 6:
                        LibraryUserController patronController = new PatronController();
                        patronController.registerUser();
                        break;
                    case 7:
                        LibraryUserController libraryClerkController = new LibraryClerkController();
                        libraryClerkController.registerUser();
                        break;
                    default:
                        System.out.println("You have chose an invalid option.");
                }
            }
        } while (choice != 1);
    }
}
