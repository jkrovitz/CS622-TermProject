package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.MainMenu;
import edu.bu.jkrovitz.console.controller.AccountController;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AdminController extends AccountController {

    @Override
    public void login() throws IOException {
        Path root = Paths.get(".").normalize().toAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(root + "/src/edu/bu/jkrovitz/console/csvs/admin.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                // use comma as separator
                String[] data = line.split(", ");
                Scanner loginInput = new Scanner(System.in);
                String username, password, role;
                do {
                    System.out.println("What is your username?");
                    username = loginInput.nextLine();
                    System.out.println("What is your password?");
                    password = loginInput.nextLine();
                    System.out.println("What is your role?");
                    role = loginInput.nextLine();
                    if ((username.equals(data[0])) && (password.equals(data[1])) && (role.equals(data[2]))) {
                        System.out.println("You have successfully logged in!");
                    } else {
                        System.out.println("Your credentials are incorrect. Please try again.");
                    }
                } while ((!(username.equals(data[0]))) || (!(password.equals(data[1]))) || (!(role.equals(data[2]))));

                MainMenu mainMenu = new MainMenu();
                mainMenu.adminMenu();

            }
        }
    }
}
