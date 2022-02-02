package edu.bu.jkrovitz.console.view.roles.genericRole;

import edu.bu.jkrovitz.console.controller.accounts.UpdateUserAttributesController;
import edu.bu.jkrovitz.console.enums.Role;

import java.util.Scanner;

public class UpdateProfileInformationView<T> {

    public void updateProfile(String role, String username, String password) {
        UpdateUserAttributesController<T> updateUserAttributesController = new UpdateUserAttributesController();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            while (true) {
                System.out.println("Do you want to 0. quit 1. Go back 2. Do you want to update your profile?");
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
                    String userRole = null;
                    if (role.equals(Role.LIBRARIAN.toString()) || role.equals(Role.LIBRARY_CLERK.toString())){
                        if (role.equals(Role.LIBRARY_CLERK.toString())){
                            userRole = Role.LIBRARY_CLERK.toString();
                        }
                        else if (role.equals(Role.LIBRARIAN.toString())){
                            userRole = Role.LIBRARIAN.toString();
                        }
                        Scanner scanner = new Scanner(System.in);
                        int updateChoice;
                        do {
                            while (true) {
                                System.out.println("Do you want to 0. quit 1. Go back 2. Update first name 3. Update last name 4. Update password");
                                if (scanner.hasNextInt()) {
                                    break;
                                }
                                String input = String.valueOf(scanner.next());
                                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
                            }
                            updateChoice = scanner.nextInt();
                            switch(updateChoice) {
                                case 0:
                                    System.exit(0);
                                case 1:
                                    break;
                                case 2:
                                    updateUserAttributesController.updateFirstName(userRole, username);
                                    break;
                                case 3:
                                    updateUserAttributesController.updateLastName(userRole, username);
                                    break;
                                case 4:
                                    updateUserAttributesController.updatePassword(userRole, username, password);
                                    break;
                                default:
                                    System.out.println("You have chose an invalid option.");
                            }

                        } while (updateChoice != 1);
                    }
                    if (role.equals(Role.PATRON.toString())){
                        Scanner scanner = new Scanner(System.in);
                        int updateChoice;
                        userRole = Role.PATRON.toString();
                        do {
                            while (true) {
                                System.out.println("Do you want to 0. quit 1. Go back 2. Update first name 3. Update last name 4. Update password 5. Update email address");
                                if (scanner.hasNextInt()) {
                                    break;
                                }
                                String input = String.valueOf(scanner.next());
                                System.out.println("Your input " + input + " is not an integer. Your input must be an integer. Please try again.\n");
                            }
                            updateChoice = scanner.nextInt();
                            switch(updateChoice) {
                                case 0:
                                    System.exit(0);
                                case 2:
                                    updateUserAttributesController.updateFirstName(userRole, username);
                                    break;
                                case 3:
                                    updateUserAttributesController.updateLastName(userRole, username);
                                    break;
                                case 4:
                                    updateUserAttributesController.updatePassword(userRole, username, password);
                                    break;
                                case 5:
                                    updateUserAttributesController.updateEmailAddress(userRole, username);
                                    break;
                                default:
                                    System.out.println("You have chose an invalid option.");
                            }
                            break;
                        } while (updateChoice != 1);
                    }
                    break;
                default:
                    System.out.println("You have chose an invalid option.");
            }
        } while (choice != 1);
    }
}
