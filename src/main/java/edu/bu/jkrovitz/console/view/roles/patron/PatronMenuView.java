package edu.bu.jkrovitz.console.view.roles.patron;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.view.books.BookSearchMenuView;
import edu.bu.jkrovitz.console.view.roles.genericRole.ProfileInformationConfirmation;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *  Displays a menu after the patron is logged in with a variety of choices they can make.
 * @author Jeremy Krovitz
 */
public class PatronMenuView {

    public void patronMenu(Role role, String username, String password) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back to the main menu 2. Search for a book 3. View your profile");
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
                    ProfileInformationConfirmation profileInformationConfirmation = new ProfileInformationConfirmation();
                    profileInformationConfirmation.viewProfileConfirmation(role, username, password);
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }
        } while (!(choice == 1));
    }
}
