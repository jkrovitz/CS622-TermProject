package edu.bu.jkrovitz.console.view.roles;

import edu.bu.jkrovitz.console.view.roles.librarian.LibrarianProfileInformationView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for methods in the LibrarianProfileInformationView class.
 *
 *  @author Jeremy Krovitz
 */
class LibrarianProfileInformationViewTest {

    @Test
    void askFirstName() {
        LibraryUserView librarianView = new LibrarianProfileInformationView();
        String input = "Jon";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, librarianView.askFirstName());
    }

    @Test
    void askLastName() {
        LibraryUserView librarianView = new LibrarianProfileInformationView();
        String input = "Smith";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, librarianView.askLastName());
    }

    @Test
    void askEmailAddress() {
        LibraryUserView librarianView = new LibrarianProfileInformationView();
        String input = "test@test.com";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, librarianView.askEmailAddress());
    }

    @Test
    void askUsername() {
        LibraryUserView librarianView = new LibrarianProfileInformationView();
        String input = "testuser";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, librarianView.askUsername());
    }

    @Test
    void askPassword() {
        LibraryUserView librarianView = new LibrarianProfileInformationView();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, librarianView.askPassword());
    }
}
