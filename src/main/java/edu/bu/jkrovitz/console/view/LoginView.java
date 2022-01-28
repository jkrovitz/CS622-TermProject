package edu.bu.jkrovitz.console.view;

import java.util.Scanner;

/**
 * Ask the user for their username and password when they login
 * and returns the Scanner input.
 *
 * @author Jeremy Krovitz
 */
public class LoginView {

    public String enterUsername() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username.");
        return sc.nextLine();
    }

    public String enterPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password.");
        return sc.nextLine();
    }
}
