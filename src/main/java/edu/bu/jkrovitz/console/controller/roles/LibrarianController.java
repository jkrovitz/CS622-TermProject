package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.model.roles.LibrarianModel;
import edu.bu.jkrovitz.console.view.roles.LibrarianView;

public class LibrarianController extends LibraryUserController {

    LibrarianView librarianView = new LibrarianView();
    LibrarianModel librarianModel = new LibrarianModel();

    @Override
    public void getInformation(){
        librarianModel.setFirstName(librarianView.askFirstName());
        librarianModel.setLastName(librarianView.askLastName());
        librarianModel.setEmailAddress(librarianView.askEmailAddress());
        librarianModel.setUsername(librarianView.askPassword());
        librarianModel.setEmployeeId(librarianView.askEmployeeId());
    }

    @Override
    public void createRole(){
        librarianModel.createRole(librarianModel.getFirstName(), librarianModel.getLastName(), librarianModel.getEmailAddress(), librarianModel.getUsername(), librarianModel.getPassword());
    }

    @Override
    public void processOutput(){
        getInformation();
        createRole();
    }

}
