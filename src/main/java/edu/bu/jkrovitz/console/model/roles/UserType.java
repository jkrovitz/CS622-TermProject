package edu.bu.jkrovitz.console.model.roles;

import edu.bu.jkrovitz.console.model.accounts.PasswordEncryption;

public class UserType<T> extends LibraryUser {

    T obj;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;
    private String confirmationPassword;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String setLastName(String lastName) {
        this.lastName = lastName;
        return this.lastName;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this.emailAddress;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    @Override
    public String getEncryptedPassword() {
        return this.password;
    }

    @Override
    public String setEncryptedPassword(String password) {
        password = PasswordEncryption.encrypt(this.password);
        this.password = password;
        return this.password;
    }

    @Override
    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    @Override
    public String setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
        return this.confirmationPassword;
    }

    @Override
    public String getEncryptedConfirmationPassword() {
        return this.confirmationPassword;
    }

    @Override
    public String setEncryptedConfirmationPassword(String confirmationPassword) {
        confirmationPassword = PasswordEncryption.encrypt(this.confirmationPassword);
        this.confirmationPassword = confirmationPassword;
        return this.confirmationPassword;
    }
}
