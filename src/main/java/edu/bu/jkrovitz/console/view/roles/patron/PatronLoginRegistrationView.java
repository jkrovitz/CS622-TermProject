package edu.bu.jkrovitz.console.view.roles.patron;

import edu.bu.jkrovitz.console.controller.LoginController;
import edu.bu.jkrovitz.console.controller.roles.PatronController;
import edu.bu.jkrovitz.console.enums.Role;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Displays a menu where a patron can decide to exit, go back, login, or register.
 *
 * @author Jeremy Krovitz
 */
public class PatronLoginRegistrationView {

    private PatronController patronController = new PatronController();

    public void askToRegisterOrLogin() throws SQLException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Login 3. Register");
                if (sc.hasNextInt()) {
                    break;
                }
            }
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    break;
                case 2:
                    LoginController loginController = new LoginController();
                    loginController.processLogin(Role.PATRON.toString());
                    break;
                case 3:
                    patronController = new PatronController();
                    patronController.registerUser();
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }

        } while (choice != 1);
    }
}
