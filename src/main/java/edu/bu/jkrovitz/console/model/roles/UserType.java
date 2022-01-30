package edu.bu.jkrovitz.console.model.roles;

import edu.bu.jkrovitz.console.model.accounts.PasswordEncryption;

public class UserType<T> extends LibraryUser {

    T obj;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
    public void setEncryptedPassword(String password) {
        password = PasswordEncryption.encrypt(this.password);
        this.password = password;
    }
}
