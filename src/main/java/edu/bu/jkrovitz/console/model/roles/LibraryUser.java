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
    private String confirmationPassword;

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this.emailAddress;
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
        return this.password;
    }

    public String getEncryptedPassword() {
        return this.password;
    }

    public String setEncryptedPassword(String password) {
        password = PasswordEncryption.encrypt(this.password);
        this.password = password;
        return this.password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public String setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
        return this.confirmationPassword;
    }

    public String getEncryptedConfirmationPassword() {
        return this.confirmationPassword;
    }

    public String setEncryptedConfirmationPassword(String confirmationPassword) {
        confirmationPassword = PasswordEncryption.encrypt(this.confirmationPassword);
        this.confirmationPassword = confirmationPassword;
        return this.confirmationPassword;
    }

}
