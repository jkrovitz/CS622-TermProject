package edu.bu.jkrovitz.console.view.roles;

import edu.bu.jkrovitz.console.controller.BookController;
import edu.bu.jkrovitz.console.controller.LoginController;
import edu.bu.jkrovitz.console.controller.roles.LibrarianController;
import edu.bu.jkrovitz.console.controller.roles.LibraryUserController;
import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.LibrarianModel;
import edu.bu.jkrovitz.console.model.roles.LibraryUserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarianView extends LibraryUserView {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;
    private String employeeId;
    private String roleType;
//    private LibrarianController librarianController;
    private RegisterModel registerModel = new RegisterModel();
    private LibrarianModel librarianModel = new LibrarianModel();

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

//    public String askEmployeeId(){
//        Scanner personInput = new Scanner(System.in);
//        System.out.println("Please enter an id for the librarian");
//        int librarianIntId = personInput.nextInt();
//        employeeId = "L" + librarianIntId;
//        return employeeId;
//    }

    @Override
    public String askRoleType(){
        roleType = super.askRoleType();
        return roleType;
    }

//    public void registerOrLogin(){
//        try {
//            librarianView = new LibrarianView();
//            librarianView.registerModel();
//        } catch(SQLException sqlException) {
//            System.out.println(sqlException.getMessage());
//        }
//    }

    public void askToRegisterOrLogin(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = -1;

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
                        try {
                            loginController.processLogin(Role.LIBRARIAN.toString());
                        } catch (SQLException | IOException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
//                        LibraryUserModel librarianModel = new LibrarianModel();
                        try {
                            registerModel.register(librarianModel.getUsername(), librarianModel.getEncryptedString(), "librarian", librarianModel.getEmailAddress(), librarianModel.getFirstName(), librarianModel.getLastName());
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("You have chose an invalid option.");
                }

        } while (choice != 1);
    }
}
