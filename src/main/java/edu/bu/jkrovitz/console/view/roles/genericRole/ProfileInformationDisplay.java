package edu.bu.jkrovitz.console.view.roles.genericRole;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.LoginModelReading;

import java.sql.SQLException;

public class ProfileInformationDisplay {

    public void viewProfile(String role, String username, String password) throws SQLException {
        LoginModelReading loginModelReading = new LoginModelReading();
        loginModelReading.displayResultsSet(role, username, password);
    }
}
