package edu.bu.jkrovitz.console.controller.accounts;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.LoginModel;
import edu.bu.jkrovitz.console.model.accounts.LoginModelReading;
import edu.bu.jkrovitz.console.view.LoginView;
import edu.bu.jkrovitz.console.view.SpecificRoleMenuView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Login controller validates a user's login.
 *
 * @author Jeremy Krovitz
 */
public class LoginController {

    LoginView loginView = new LoginView();
    LoginModel loginModel = new LoginModel();
    LoginModelReading loginModelReading = new LoginModelReading();

    public void processLogin(Role role) throws SQLException, IOException, ParseException {
        String keepGoing = "";
        do {
            String username = loginModel.setUsername(loginView.enterUsername());
            String password = loginModel.setEncryptedPassword(loginModel.setPassword(loginView.enterPassword()));
            Scanner sc = new Scanner(System.in);
            String stringRole = role.toString();
            boolean result = loginModelReading.validateLogin(stringRole, username, password);
            if (result) {
                SpecificRoleMenuView specificRoleMenuView = new SpecificRoleMenuView();
                specificRoleMenuView.openSpecificRoleMenu(role, username, password);
                break;
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

//    public void processLogin(Role role) throws SQLException, IOException, ParseException {
//        retrieveFromDatabase(role);
//    }
}
