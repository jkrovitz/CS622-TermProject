package edu.bu.jkrovitz.console.view.roles;

import edu.bu.jkrovitz.console.view.roles.patron.PatronProfileInformationView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for methods in the PatronProfileInformationView class.
 *
 * @author Jeremy Krovitz
 */
class PatronProfileInformationViewTest {

    @Test
    void askFirstName() {
        LibraryUserView patronView = new PatronProfileInformationView();
        String input = "Jon";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, patronView.askFirstName());
    }

    @Test
    void askLastName() {
        LibraryUserView patronView = new PatronProfileInformationView();
        String input = "Smith";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, patronView.askLastName());
    }

    @Test
    void askEmailAddress() {
        LibraryUserView patronView = new PatronProfileInformationView();
        String input = "test@test.com";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, patronView.askEmailAddress());
    }

    @Test
    void askUsername() {
        LibraryUserView patronView = new PatronProfileInformationView();
        String input = "testuser";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, patronView.askUsername());
    }

    @Test
    void askPassword() {
        LibraryUserView patronView = new PatronProfileInformationView();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, patronView.askPassword());
    }
}