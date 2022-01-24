package edu.bu.jkrovitz.console.controller;

import java.io.IOException;
import java.sql.SQLException;

public abstract class AccountController {

    public abstract void login() throws IOException, SQLException;

}
