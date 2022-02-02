package edu.bu.jkrovitz.console.controller.accounts;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Abstract class provides method signature for one abstract method.
 *
 * @author Jeremy Krovitz
 */
public abstract class AccountController {

    public abstract void login() throws IOException, SQLException, ParseException;

}
