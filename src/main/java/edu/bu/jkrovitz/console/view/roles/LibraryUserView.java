package edu.bu.jkrovitz.console.view.roles;

import edu.bu.jkrovitz.console.model.accounts.PasswordEncryption;

import java.util.Scanner;

abstract public class LibraryUserView {

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

    public String askPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a password");
        return scanner.nextLine();
    }

    public String askRoleType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the role type.");
        return scanner.nextLine();
    }
}
