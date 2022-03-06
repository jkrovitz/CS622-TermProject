package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.controller.accounts.AccountController;
import edu.bu.jkrovitz.console.view.roles.admin.AdminLoginView;
import edu.bu.jkrovitz.console.view.roles.admin.AdminMenuView;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class processes administrator's login attempt.
 *
 * @author Jeremy Krovitz
 */
public class AdminController extends AccountController {

    private AdminLoginView adminLoginView = new AdminLoginView();

    @Override
    public void login() throws IOException, SQLException, ParseException {
        Path root = Paths.get(".").normalize().toAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(root + "/src/main/resources/edu.bu.jkrovitz/csvs/admin.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                // use comma as separator
                String[] data = line.split(", ");
                System.out.println(Arrays.toString(data));
                Scanner loginInput = new Scanner(System.in);
                String[] userAttributes = new String[3];
                do {
                    userAttributes = adminLoginView.loginAdminView(loginInput);

                    if ((userAttributes[0].equals(data[0])) && (userAttributes[1]).equals(data[1])) {
                        System.out.println("You have successfully logged in!");
                    } else {
                        System.out.println("Your credentials are incorrect. Please try again.");
                    }
                } while ((!(userAttributes[0].equals(data[0]))) || (!(userAttributes[1].equals(data[1]))));

                AdminMenuView adminMenuView = new AdminMenuView();
                adminMenuView.adminMenu();

            }
        }
    }
}
