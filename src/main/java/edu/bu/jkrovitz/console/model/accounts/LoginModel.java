package edu.bu.jkrovitz.console.model.accounts;

public class LoginModel {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return this.password;
    }

    public String setEncryptedPassword(String password) {
        password = PasswordEncryption.encrypt(this.password);
        this.password = password;
        return this.password;
    }
}
