package edu.bu.jkrovitz.console.view.roles;

import edu.bu.jkrovitz.console.controller.LoginController;
import edu.bu.jkrovitz.console.controller.roles.LibrarianController;
import edu.bu.jkrovitz.console.controller.roles.LibraryClerkController;
import edu.bu.jkrovitz.console.controller.roles.PatronController;
import edu.bu.jkrovitz.console.enums.Role;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PatronView extends LibraryUserView {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;
    private String roleType;
    private PatronController patronController;

    @Override
    public String askFirstName(){
        firstName = super.askFirstName();
        return firstName;
    }

    @Override
    public String askLastName() {
        lastName = super.askLastName();
        return lastName;
    }

    @Override
    public String askEmailAddress() {
        emailAddress = super.askEmailAddress();
        return emailAddress;
    }

    @Override
    public String askUsername() {
        username = super.askUsername();
        return username;
    }

    @Override
    public String askPassword(){
        password = super.askPassword();
        return password;
    }

    @Override
    public String askRoleType(){
        roleType = super.askRoleType();
        return roleType;
    }

    public void askToRegisterOrLogin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;

            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Login 3. Register");
                if (sc.hasNextInt()) {
                    break;
                }
//                String input = String.valueOf(sc.next());
//                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    break;
                case 2:
                    LoginController loginController = new LoginController();
                    try {
                        loginController.processLogin(Role.PATRON.toString());
                    } catch (SQLException | IOException e) {
                        System.out.println(e.getMessage());
                    }
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
