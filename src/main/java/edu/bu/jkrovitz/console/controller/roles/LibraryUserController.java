package edu.bu.jkrovitz.console.controller.roles;

import java.sql.SQLException;

public abstract class LibraryUserController {

    public abstract void getInformation();

    public abstract void createRole();

    public abstract void processOutput() throws SQLException;

}
