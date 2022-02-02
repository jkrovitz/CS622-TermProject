package edu.bu.jkrovitz.console.view.roles.genericRole;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.LoginModel;
import edu.bu.jkrovitz.console.model.accounts.LoginModelReading;
import edu.bu.jkrovitz.console.view.LoginView;

import java.sql.SQLException;
import java.util.Scanner;


public class ProfileInformationConfirmation {

    LoginView loginView = new LoginView();
    LoginModel loginModel = new LoginModel();
    LoginModelReading loginModelReading = new LoginModelReading();

    public void viewProfileConfirmation(Role role, String username, String password){
        String keepGoing = "";
        do {
            String passwordInput = loginModel.setEncryptedPassword(loginModel.setPassword(loginView.enterPassword()));
            Scanner sc = new Scanner(System.in);
            String stringRole = role.toString();
            boolean result = false;
            if (passwordInput.equals(password)) {
                try {
                    result = loginModelReading.validateLogin(stringRole, username, passwordInput);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (result) {
                    ProfileInformationDisplay profileInformationDisplay = new ProfileInformationDisplay();
                    UpdateProfileInformationView updateProfileInformationView = new UpdateProfileInformationView();
                    try {
                        profileInformationDisplay.viewProfile(stringRole, username, password);
                        updateProfileInformationView.updateProfile(stringRole, username, password);
                        break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.print("Username and/or password are invalid. Press <Enter> to try again, \"b\" to go back, or \"q\" to quit.\n");
            keepGoing = sc.nextLine();
            if (keepGoing.equals("b")) {
                break;
            }
            if (keepGoing.equals("q")) {
                System.exit(0);
            }
        } while (true);
    }
}
