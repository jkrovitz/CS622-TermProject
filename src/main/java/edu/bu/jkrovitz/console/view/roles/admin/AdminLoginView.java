package edu.bu.jkrovitz.console.view.roles.admin;

import java.util.Scanner;

/***
 * Asks an admin for their login information.
 */
public class AdminLoginView {

    public String[] loginAdminView(Scanner loginInput) {
        String[] userAttributes = new String[3];
        System.out.println("What is your username?");
        String username = loginInput.nextLine();
        System.out.println("What is your password?");
        String password = loginInput.nextLine();
        String role = "admin";
        userAttributes[0] = username;
        userAttributes[1] = password;
        userAttributes[2] = role;
        return userAttributes;
    }
}
