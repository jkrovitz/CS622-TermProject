package edu.bu.jkrovitz.console;

import edu.bu.jkrovitz.console.controller.*;
import edu.bu.jkrovitz.console.controller.roles.*;
import edu.bu.jkrovitz.console.model.BookModel;
import edu.bu.jkrovitz.console.view.books.BookView;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws IOException {
        MainMenu mainMenu = new MainMenu();
        int choice;
        boolean isIncorrectAnswer;
        Scanner sc = new Scanner(System.in);

        do {
            choice = -1;
            System.out.println("Are you 1. an Admin, 2. Librarian, or 3. Checkout Clerk 4.Patron, 0. Quit?");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        AccountController admin = new AdminController();
                        admin.login();
                        break;
                    case 2:
                        mainMenu.librarianMenu();
                        break;
                    case 3:
                        mainMenu.libraryClerkMenu();
                        break;
                    case 4:
                        mainMenu.patronMenu();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("You have chose an invalid option.");
                        isIncorrectAnswer = true;

                }

            }
        } while (choice != 0);

        sc.close();
    }

    public void patronMenu(){
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            choice = -1;
            System.out.println("Do you want to 0. quit 1. Search for a book 2. Go back to the main menu");
            if (sc.hasNextInt()) {
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
            }
        } while (!(choice == 2));
    }

    public void libraryClerkMenu(){
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            choice = -1;
            System.out.println("Do you want to 0. quit 1. Search for a book 2. Go back to main menu.");
            if (sc.hasNextInt()) {
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
            }
        } while (!(choice == 2));
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
                    case 3:
                        BookView bookView = new BookView();
                        bookView.askTitle();
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
