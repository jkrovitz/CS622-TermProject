package edu.bu.jkrovitz.console;

import edu.bu.jkrovitz.console.controller.accounts.AccountController;
import edu.bu.jkrovitz.console.controller.roles.AdminController;
import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.Database;
import edu.bu.jkrovitz.console.view.roles.genericRole.GenericLoginRegistrationView;
import edu.bu.jkrovitz.console.view.roles.patron.PatronLoginRegistrationView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This class handles the main menu of the program where a user selects a role in the library management system.
 *
 * @author Jeremy Krovitz
 */
public class MainMenu {

    public static void main(String[] args) throws IOException, SQLException, ParseException {
        int choice;
        Scanner sc = new Scanner(System.in);
        Database.connectToDatabase();
        Database.createTables();

        choice = -1;
        do {
            choice = -1;
            while (true) {
                System.out.println("Are you 1. an Admin, 2. Librarian, or 3. Checkout Clerk 4.Patron, 0. Quit?");
                if (sc.hasNextInt()) {
                    break;
                }
                String input = String.valueOf(sc.next());
                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }
            if (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AccountController admin = new AdminController();
                    try {
                        admin.login();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    GenericLoginRegistrationView librarianLoginRegistrationView = new GenericLoginRegistrationView();
                    librarianLoginRegistrationView.askToRegisterOrLogin(Role.LIBRARIAN);
                    break;
                case 3:
                    GenericLoginRegistrationView libraryClerkLoginRegistrationView = new GenericLoginRegistrationView();
                    libraryClerkLoginRegistrationView.askToRegisterOrLogin(Role.LIBRARY_CLERK);
                    break;
                case 4:
                    PatronLoginRegistrationView patronLoginRegistrationView = new PatronLoginRegistrationView();
                    patronLoginRegistrationView.askToRegisterOrLogin(Role.PATRON);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("You have chose an invalid option.");
            }
        } while (choice != 0);
        sc.close();
    }
}
