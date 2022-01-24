package edu.bu.jkrovitz.console.controller;

import edu.bu.jkrovitz.console.MainMenu;
import edu.bu.jkrovitz.console.model.accounts.LoginModelReading;
import edu.bu.jkrovitz.console.model.accounts.PasswordEncryption;
import edu.bu.jkrovitz.console.view.LoginView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginController {

    LoginView loginView = new LoginView();
    LoginModelReading loginModel = new LoginModelReading();

   public void retrieveFromDatabase(String role) throws SQLException, IOException {
      String keepGoing = "";
       do {
           String username = loginModel.setUsername(loginView.enterUsername());
           String password = loginModel.setPassword(loginView.enterPassword());
           Scanner sc = new Scanner(System.in);
           boolean result = loginModel.retrieveFromDatabase(role, username, PasswordEncryption.encrypt(password));
           if (result) {
               MainMenu mainMenu = new MainMenu();
               mainMenu.librarianMenu();
               break;
           }
               System.out.print("Username and/or password are invalid. Press <Enter> to try again, \"b\" to go back, or \"q\" to quit.\n");
               keepGoing = sc.nextLine();
               if (keepGoing.equals("b")) {
                   break;
               }
               if (keepGoing.equals("q")){
                   System.exit(0);
               }
       } while(true);
   }

   public void processLogin(String role) throws SQLException, IOException {
       retrieveFromDatabase(role);
   }
}
