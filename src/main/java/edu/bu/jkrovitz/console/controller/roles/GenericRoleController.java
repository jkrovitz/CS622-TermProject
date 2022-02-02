package edu.bu.jkrovitz.console.controller.roles;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.model.accounts.RegisterModel;
import edu.bu.jkrovitz.console.model.roles.UserType;
import edu.bu.jkrovitz.console.view.roles.genericRole.GeneralProfileInformationView;

import java.sql.SQLException;

/**
 * Handles the interaction between getting the generic profile information from the view, setting the userType profile information,
 * and saving to a database.
 *
 * @author Jeremy Krovitz
 */
public class GenericRoleController<T> extends LibraryUserController {

    GeneralProfileInformationView generalProfileInformationView = new GeneralProfileInformationView();
    UserType<T> userType = new UserType<T>();
    RegisterModel registerModel = new RegisterModel();

    @Override
    public void getInformation(){
        String password = null;
        String confirmationPassword = null;

        userType.setUsername(generalProfileInformationView.askUsername());

        do {
            password = generalProfileInformationView.askPassword();
            confirmationPassword = generalProfileInformationView.askPasswordConfirmation();
            if (password.equals(confirmationPassword)) {
                break;
            }
            System.out.println("The two passwords do not match. Please try again.");
        } while(!password.equals(confirmationPassword));

        userType.setEncryptedPassword(userType.setPassword(password));
        userType.setEncryptedConfirmationPassword(userType.setConfirmationPassword(confirmationPassword));
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
}
