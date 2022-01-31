package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.Librarian;
import edu.bu.jkrovitz.console.view.roles.librarian.LibrarianProfileInformationView;

import java.sql.SQLException;

/**
 * Handles the interaction between getting the librarian profile information from the view, setting the librarian profile information,
 * and saving to a database.
 *
 * @author Jeremy Krovitz
 */
public class LibrarianController extends LibraryUserController {

    LibrarianProfileInformationView librarianProfileInformationView = new LibrarianProfileInformationView();
    Librarian librarian = new Librarian();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        librarian.setUsername(librarianProfileInformationView.askUsername());
        librarian.setEncryptedPassword(librarian.setPassword(librarianProfileInformationView.askPassword()));
        librarian.setEmailAddress(librarianProfileInformationView.askEmailAddress());
        librarian.setFirstName(librarianProfileInformationView.askFirstName());
        librarian.setLastName(librarianProfileInformationView.askLastName());
    }

    public void registerModel() throws SQLException {
        registerModel.register(librarian.getUsername(), librarian.getPassword(), Role.LIBRARIAN.toString(), librarian.getEmailAddress(), librarian.getFirstName(), librarian.getLastName());
    }

    public void registerUser() throws SQLException {
        getInformation();
        registerModel();
    }
}
