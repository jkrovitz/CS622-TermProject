package edu.bu.jkrovitz.console.view.roles.libraryclerk;

import edu.bu.jkrovitz.console.controller.roles.GenericRoleController;
import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.view.books.BookSearchMenuView;
import edu.bu.jkrovitz.console.view.roles.genericRole.ProfileInformationConfirmation;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Displays a menu after the library clerk is logged in with a variety of choices they can make.
 *
 * @author Jeremy Krovitz
 */
public class LibraryClerkMenuView<T> {

    public void libraryClerkMenu(Role role, String username, String password) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back to main menu. 2. Search for a book 3. Add patron 4. View profile");
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
                    BookSearchMenuView bookSearchMenuView = new BookSearchMenuView();
                    bookSearchMenuView.chooseBookSearchMethod();
                    break;
                case 3:
                    GenericRoleController<T> patronController = new GenericRoleController<>();
                    patronController.registerUser(Role.PATRON);
                    break;
                case 4:
                    ProfileInformationConfirmation profileInformationConfirmation = new ProfileInformationConfirmation();
                    profileInformationConfirmation.viewProfileConfirmation(role, username, password);
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
                    break;
            }
        } while (!(choice == 1));
    }
}
