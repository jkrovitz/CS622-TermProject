package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.UserType;
import edu.bu.jkrovitz.console.view.roles.librarian.GeneralProfileInformationView;

import java.sql.SQLException;

/**
 * Handles the interaction between getting the generic profile information from the view, setting the userType profile information,
 * and saving to a database.
 *
 * @author Jeremy Krovitz
 */
public class GenericController<T> extends LibraryUserController {

    public T t;
    GeneralProfileInformationView generalProfileInformationView = new GeneralProfileInformationView();
    UserType<T> userType = new UserType<T>();
    //    LibrarianProfileInformationView generalProfileInformationView = new LibrarianProfileInformationView();
//    Librarian userType = new Librarian();
    RegisterModel registerModel = new RegisterModel();
    Role role;

    public void setT(T t){
        this.t = t;
    }

    public T getT(){
        return this.t;
    }

    @Override
    public void getInformation(){
        userType.setUsername(generalProfileInformationView.askUsername());
        userType.setEncryptedPassword(userType.setPassword(generalProfileInformationView.askPassword()));
        userType.setEmailAddress(generalProfileInformationView.askEmailAddress());
        userType.setFirstName(generalProfileInformationView.askFirstName());
        userType.setLastName(generalProfileInformationView.askLastName());
    }

    public void registerModel(Role role) throws SQLException {
        registerModel.register(userType.getUsername(), userType.getPassword(), role.toString(), userType.getEmailAddress(), userType.getFirstName(), userType.getLastName());
    }

    public void registerUser(Role role) throws SQLException {
        getInformation();
        registerModel(role);
    }

    public void registerUser(){

    }
}
