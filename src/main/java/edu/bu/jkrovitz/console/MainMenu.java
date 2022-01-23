package edu.bu.jkrovitz.console;

import edu.bu.jkrovitz.console.controller.*;
import edu.bu.jkrovitz.console.controller.roles.*;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws IOException {
        MainMenu mainMenu = new MainMenu();

        boolean isIncorrectAnswer;
        Scanner sc = new Scanner(System.in);

        do {
            isIncorrectAnswer = false;
            System.out.println("Are you 1. an Admin, 2. Librarian, or 3. Checkout Clerk 4.Patron, 0. Quit?");
            switch(sc.nextInt()) {
                case 1:
                    AccountController admin = new AdminController();
                    admin.login();
                    break;
                case 2:
                    mainMenu.librarianMenu();
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
                    isIncorrectAnswer = true;

            }
        } while (isIncorrectAnswer);

        sc.close();
    }

    public void librarianMenu() throws IOException {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            choice = -1;
            System.out.println("Do you want to 0. quit 1. Add a new book? 2. search");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        BookController bookController = new BookController();
                        bookController.processOutput();
                        break;
                    case 2:
                        BookFinderController bookControllerFinder = new BookFinderController();
                        bookControllerFinder.findBook();
                        break;
                    default:
                        System.out.println("You have chose an invalid option.");
                }
            }
        } while (choice != 0);

    }

    public void adminMenu(){
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            choice = -1;
            System.out.println("Do you want to 0. quit 1. Add a new book? 2. Add a new Librarian?");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        BookController bookController = new BookController();
                        bookController.processOutput();
                        break;
                    case 2:
                        LibraryUserController librarian = new LibrarianController();
                        librarian.createRole();
                        break;
                    default:
                        System.out.println("You have chose an invalid option.");
                }
            }
        } while (choice != 0);
    }
}
