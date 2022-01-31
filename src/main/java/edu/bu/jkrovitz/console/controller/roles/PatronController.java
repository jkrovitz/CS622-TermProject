package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.Patron;
import edu.bu.jkrovitz.console.view.roles.patron.PatronProfileInformationView;

import java.sql.SQLException;

/**
 * Handles the interaction between getting the patron profile information from the view, setting the patron profile information,
 * and saving to a database.
 *
 * @author Jeremy Krovitz
 */
public class PatronController extends LibraryUserController{

    PatronProfileInformationView patronProfileInformationView = new PatronProfileInformationView();
    Patron patronModel = new Patron();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        patronModel.setUsername(patronProfileInformationView.askUsername());
        patronModel.setEncryptedPassword(patronModel.setPassword(patronProfileInformationView.askPassword()));
        patronModel.setEmailAddress(patronProfileInformationView.askEmailAddress());
        patronModel.setFirstName(patronProfileInformationView.askFirstName());
        patronModel.setLastName(patronProfileInformationView.askLastName());
    }

    public void registerModel() throws SQLException {
        registerModel.register(patronModel.getUsername(), patronModel.getEncryptedPassword(), Role.PATRON.toString(), patronModel.getEmailAddress(), patronModel.getFirstName(), patronModel.getLastName());
    }

    public void registerUser() throws SQLException {
        getInformation();
        registerModel();
    }
}
