package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.controller.BookController;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.LibrarianModel;
import edu.bu.jkrovitz.console.view.roles.LibrarianView;

import java.sql.SQLException;
import java.util.Scanner;

public class LibrarianController extends LibraryUserController {

    LibrarianView librarianView = new LibrarianView();
    LibrarianModel librarianModel = new LibrarianModel();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        librarianModel.setUsername(librarianView.askUsername());
        librarianModel.setPassword(librarianView.askPassword());
        librarianModel.setEmailAddress(librarianView.askEmailAddress());
        librarianModel.setFirstName(librarianView.askFirstName());
        librarianModel.setLastName(librarianView.askLastName());
//        librarianModel.setEmailAddress(librarianView.askEmailAddress());
//        librarianModel.setUsername(librarianView.askPassword());
//        librarianModel.setEmployeeId(librarianView.askEmployeeId());
    }

    @Override
    public void createRole(){
        librarianModel.createRole(librarianModel.getFirstName(), librarianModel.getLastName(), librarianModel.getEmailAddress(), librarianModel.getUsername(), librarianModel.getPassword());
    }

    public void registerModel() throws SQLException {
        registerModel.register(librarianModel.getUsername(), librarianModel.getEncryptedString(), "librarian", librarianModel.getEmailAddress(), librarianModel.getFirstName(), librarianModel.getLastName());
    }

    @Override
    public void processOutput() throws SQLException {
        getInformation();
//        createRole();
        registerModel();
    }

    public void registerOrLogin() {
        librarianView.askToRegisterOrLogin();
    }

}
