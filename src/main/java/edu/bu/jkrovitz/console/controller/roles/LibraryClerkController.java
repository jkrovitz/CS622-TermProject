package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.LibraryClerkModel;
import edu.bu.jkrovitz.console.view.roles.LibraryClerkView;

import java.sql.SQLException;

public class LibraryClerkController extends LibraryUserController{

    LibraryClerkView libraryClerkView = new LibraryClerkView();
    LibraryClerkModel libraryClerkModel = new LibraryClerkModel();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        libraryClerkModel.setUsername(libraryClerkView.askUsername());
        libraryClerkModel.setEncryptedPassword(libraryClerkModel.setPassword(libraryClerkView.askPassword()));
        libraryClerkModel.setEmailAddress(libraryClerkView.askEmailAddress());
        libraryClerkModel.setFirstName(libraryClerkView.askFirstName());
        libraryClerkModel.setLastName(libraryClerkView.askLastName());
    }

    @Override
    public void createRole(){
        libraryClerkModel.createRole(libraryClerkModel.getFirstName(), libraryClerkModel.getLastName(), libraryClerkModel.getEmailAddress(), libraryClerkModel.getUsername(), libraryClerkModel.getPassword());
    }

    public void registerModel() throws SQLException {
        registerModel.register(libraryClerkModel.getUsername(), libraryClerkModel.getEncryptedPassword(), Role.LIBRARY_CLERK.toString(), libraryClerkModel.getEmailAddress(), libraryClerkModel.getFirstName(), libraryClerkModel.getLastName());
    }

    @Override
    public void registerUser() throws SQLException {
        getInformation();
        registerModel();
    }
}
