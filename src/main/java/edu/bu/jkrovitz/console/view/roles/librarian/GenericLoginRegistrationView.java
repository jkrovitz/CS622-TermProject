package edu.bu.jkrovitz.console.view.roles.librarian;

import edu.bu.jkrovitz.console.controller.LoginController;
import edu.bu.jkrovitz.console.controller.roles.GenericController;
import edu.bu.jkrovitz.console.controller.roles.LibrarianController;
import edu.bu.jkrovitz.console.enums.Role;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Displays a menu where the user can decide to exit, go back, login, or register.
 *
 * @author Jeremy Krovitz
 */
public class GenericLoginRegistrationView {

    public <T> void askToRegisterOrLogin(Role role) throws SQLException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Login 3. Register");
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
                    LoginController loginController = new LoginController();
                    loginController.processLogin(role.toString());
                    break;
                case 3:
                    GenericController<T> genericController = new GenericController<>();
                    genericController.registerUser(role);
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }

        } while (choice != 1);
    }
}
