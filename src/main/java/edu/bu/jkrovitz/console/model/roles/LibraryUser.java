package edu.bu.jkrovitz.console.model.roles;

import edu.bu.jkrovitz.console.model.accounts.PasswordEncryption;

/**
 * This class sets and gets various attributes relating to a general library user.
 *
 * @author Jeremy Krovitz
 */
public class LibraryUser {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String getEncryptedPassword() {
        return this.password;
    }

    public void setEncryptedPassword(String password) {
        password = PasswordEncryption.encrypt(this.password);
        this.password = password;
    }

}
