package edu.bu.jkrovitz.console.view;

import edu.bu.jkrovitz.console.enums.Role;
import edu.bu.jkrovitz.console.view.roles.admin.AdminMenuView;
import edu.bu.jkrovitz.console.view.roles.librarian.LibrarianMenuView;
import edu.bu.jkrovitz.console.view.roles.libraryclerk.LibraryClerkMenuView;
import edu.bu.jkrovitz.console.view.roles.patron.PatronMenuView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Opens a specific menu based off of which role has been logged in.
 *
 * @author Jeremy Krovitz
 */
public class SpecificRoleMenuView {

    public void openSpecificRoleMenu(String role) throws SQLException, IOException, ParseException {
        if (role.equals(Role.PATRON.toString())) {
            PatronMenuView patronMenuView = new PatronMenuView();
            patronMenuView.patronMenu();
        }
        if (role.equals(Role.LIBRARY_CLERK.toString())) {
            LibraryClerkMenuView libraryClerkMenuView = new LibraryClerkMenuView();
            libraryClerkMenuView.libraryClerkMenu();
        }
        if (role.equals(Role.LIBRARIAN.toString())) {
            LibrarianMenuView librarianMenuView = new LibrarianMenuView();
            librarianMenuView.librarianMenu();
        }
        if (role.equals(Role.ADMIN.toString())) {
            AdminMenuView adminMenuView = new AdminMenuView();
            adminMenuView.adminMenu();
        }
    }
}
