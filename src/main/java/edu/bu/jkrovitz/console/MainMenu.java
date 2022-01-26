package edu.bu.jkrovitz.console;

import edu.bu.jkrovitz.console.controller.*;
import edu.bu.jkrovitz.console.controller.roles.*;
import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.Database;
import edu.bu.jkrovitz.console.model.accounts.LoginTableModel;
import edu.bu.jkrovitz.console.view.roles.LibrarianView;
import edu.bu.jkrovitz.console.view.roles.LibraryClerkView;
import edu.bu.jkrovitz.console.view.roles.PatronView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws IOException, SQLException {
        MainMenu mainMenu = new MainMenu();
        int choice;
        boolean isIncorrectAnswer;
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
                    admin.login();
                    break;
                case 2:
                    LibrarianView librarianView = new LibrarianView();
                    librarianView.askToRegisterOrLogin();
                    break;
                case 3:
                    LibraryClerkView libraryClerkView = new LibraryClerkView();
                    libraryClerkView.askToRegisterOrLogin();
                    break;
                case 4:
                    PatronView patronView = new PatronView();
                    patronView.askToRegisterOrLogin();
                    break;
                case 5:
                    LoginTableModel loginTableModel = new LoginTableModel();
                    loginTableModel.addLoginTable();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("You have chose an invalid option.");
                    isIncorrectAnswer = true;
            }
        } while (choice != 0);
        sc.close();
    }

    public void openSpecificRoleMenu(String role) throws SQLException {
        if (role.equals(Role.PATRON.toString())) {
            patronMenu();
        }
        if (role.equals(Role.LIBRARY_CLERK.toString())) {
            libraryClerkMenu();
        }
        if (role.equals(Role.LIBRARIAN.toString())) {
            try {
                librarianMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (role.equals(Role.ADMIN.toString())) {
            adminMenu();
        }
    }

    public void patronMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Search for a book 2. Go back to the main menu");
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
                    BookFinderController bookControllerFinder = new BookFinderController();
                    bookControllerFinder.findBook();
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }

        } while (!(choice == 2));
    }

    public void libraryClerkMenu() {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            choice = -1;
            while (true) {
                System.out.println("Do you want to 0. quit 1. Search for a book 2. Go back to main menu.");
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
                    BookFinderController bookControllerFinder = new BookFinderController();
                    bookControllerFinder.findBook();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }

        } while (!(choice == 2));
    }

    public void librarianMenu() throws IOException {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            choice = -1;

            while (true) {

                System.out.println("Do you want to 0. quit 1. Go Back 2. Add a new book? 3. search");


                if (sc.hasNextInt()) {
                    break;
                }
//                String input = String.valueOf(sc.next());
//                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }
//
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    break;
                case 2:
                    BookController bookController = new BookController();
                    bookController.processOutput();
                    break;
                case 3:
                    BookFinderController bookControllerFinder = new BookFinderController();
                    bookControllerFinder.findBook();
                    break;
                case 4:
//                        BookView bookView = new BookView();
//                        bookView.askTitle();
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }
//
        } while (choice != 1);

    }

    public void adminMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;

            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Add a new book? 3. Add a new Librarian?");
                if (sc.hasNextInt()) {
                    break;
                }
                String input = String.valueOf(sc.next());
                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
            }

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        System.exit(0);
                    case 1:
                        break;
                    case 2:
                        BookController bookController = new BookController();
                        bookController.processOutput();
                        break;
                    case 3:
                        LibraryUserController librarian = new LibrarianController();
                        librarian.registerUser();
                        break;
                    default:
                        System.out.println("You have chose an invalid option.");
                }
            }
        } while (choice != 1);
    }
}
