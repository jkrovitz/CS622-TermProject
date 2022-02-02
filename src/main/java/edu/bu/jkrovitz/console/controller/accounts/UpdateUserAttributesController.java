package edu.bu.jkrovitz.console.controller.accounts;

import edu.bu.jkrovitz.console.model.accounts.UpdateProfileAttributes;
import edu.bu.jkrovitz.console.model.roles.UserType;
import edu.bu.jkrovitz.console.view.roles.genericRole.GeneralProfileInformationView;

import java.sql.SQLException;

public class UpdateUserAttributesController<T> {

    GeneralProfileInformationView generalProfileInformationView = new GeneralProfileInformationView();
    UserType<T> userType = new UserType<T>();
    UpdateProfileAttributes updateProfileAttributes = new UpdateProfileAttributes();

    public String askUpdatePassword(String role, String username, String password){
        String confirmationPassword = null;
        do {
            password = generalProfileInformationView.askPassword();
            confirmationPassword = generalProfileInformationView.askPasswordConfirmation();
            if (password.equals(confirmationPassword)) {
                break;
            }
            System.out.println("The two passwords do not match. Please try again.");
        } while(!password.equals(confirmationPassword));

        password = userType.setEncryptedPassword(userType.setPassword(password));
        userType.setEncryptedConfirmationPassword(userType.setConfirmationPassword(confirmationPassword));

        return password;
    }

    public void updatePassword(String role, String username, String password){
        String newPassword = askUpdatePassword(role, username, password);
        try {
            updateProfileAttributes.updateProfileAttribute("password", newPassword, role, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFirstName(String role, String username){
        String firstName = userType.setFirstName(generalProfileInformationView.askFirstName());
        try {
            updateProfileAttributes.updateProfileAttribute("first_name", firstName, role, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLastName(String role, String username){
        String lastName = userType.setLastName(generalProfileInformationView.askLastName());
        try {
            updateProfileAttributes.updateProfileAttribute("last_name", lastName, role, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmailAddress(String role, String username){
        String emailAddress = userType.setEmailAddress(generalProfileInformationView.askEmailAddress());
        try {
            updateProfileAttributes.updateProfileAttribute("email_address", emailAddress, role, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
