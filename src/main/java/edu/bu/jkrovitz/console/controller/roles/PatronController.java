package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.PatronModel;
import edu.bu.jkrovitz.console.view.roles.PatronView;

import java.sql.SQLException;

public class PatronController extends LibraryUserController{

    PatronView patronView = new PatronView();
    PatronModel patronModel = new PatronModel();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        patronModel.setUsername(patronView.askUsername());
        patronModel.setEncryptedPassword(patronModel.setPassword(patronView.askPassword()));
        patronModel.setEmailAddress(patronView.askEmailAddress());
        patronModel.setFirstName(patronView.askFirstName());
        patronModel.setLastName(patronView.askLastName());
    }

    @Override
    public void createRole(){
        patronModel.createRole(patronModel.getFirstName(), patronModel.getLastName(), patronModel.getEmailAddress(), patronModel.getUsername(), patronModel.getPassword());
    }

    public void registerModel() throws SQLException {
        registerModel.register(patronModel.getUsername(), patronModel.getEncryptedPassword(), Role.PATRON.toString(), patronModel.getEmailAddress(), patronModel.getFirstName(), patronModel.getLastName());
    }

    @Override
    public void registerUser() throws SQLException {
        getInformation();
        registerModel();
    }
}
