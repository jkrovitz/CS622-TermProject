package edu.bu.jkrovitz.console.view.roles;

import java.util.Scanner;

/**
 * Abstract class sets up a variety of questions for a library user's profile information.
 */
public abstract class LibraryUserView {

    public String askFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first name");
        return scanner.nextLine();
    }

    public String askLastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter last name");
        return scanner.nextLine();
    }

    public String askEmailAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter email address");
        return scanner.nextLine();
    }

    public String askUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username");
        return scanner.nextLine();
    }

    public String askPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a password");
        return scanner.nextLine();
    }
}
