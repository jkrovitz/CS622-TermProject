package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.LibraryClerk;
import edu.bu.jkrovitz.console.view.roles.libraryclerk.LibraryClerkProfileInformationView;

import java.sql.SQLException;

/**
 * Handles the interaction between getting the library clerk profile information from the view, setting the library clerk profile information,
 * and saving to a database.
 *
 * @author Jeremy Krovitz
 */
public class LibraryClerkController extends LibraryUserController{

    LibraryClerkProfileInformationView libraryClerkProfileInformationView = new LibraryClerkProfileInformationView();
    LibraryClerk libraryClerk = new LibraryClerk();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        libraryClerk.setUsername(libraryClerkProfileInformationView.askUsername());
        libraryClerk.setEncryptedPassword(libraryClerk.setPassword(libraryClerkProfileInformationView.askPassword()));
        libraryClerk.setEmailAddress(libraryClerkProfileInformationView.askEmailAddress());
        libraryClerk.setFirstName(libraryClerkProfileInformationView.askFirstName());
        libraryClerk.setLastName(libraryClerkProfileInformationView.askLastName());
    }

    public void registerModel() throws SQLException {
        registerModel.register(libraryClerk.getUsername(), libraryClerk.getEncryptedPassword(), Role.LIBRARY_CLERK.toString(), libraryClerk.getEmailAddress(), libraryClerk.getFirstName(), libraryClerk.getLastName());
    }

    public void registerUser() throws SQLException {
        getInformation();
        registerModel();
    }
}
