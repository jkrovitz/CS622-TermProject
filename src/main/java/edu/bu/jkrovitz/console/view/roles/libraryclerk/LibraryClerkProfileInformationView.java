package edu.bu.jkrovitz.console.view.roles.libraryclerk;

import edu.bu.jkrovitz.console.view.roles.LibraryUserView;

/**
 * Ask library clerk profile information.
 *
 * @author Jeremy Krovitz
 */
public class LibraryClerkProfileInformationView extends LibraryUserView {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;

    @Override
    public String askFirstName() {
        firstName = super.askFirstName();
        return firstName;
    }

    @Override
    public String askLastName() {
        lastName = super.askLastName();
        return lastName;
    }

    @Override
    public String askEmailAddress() {
        emailAddress = super.askEmailAddress();
        return emailAddress;
    }

    @Override
    public String askUsername() {
        username = super.askUsername();
        return username;
    }

    @Override
    public String askPassword() {
        password = super.askPassword();
        return password;
    }

}
