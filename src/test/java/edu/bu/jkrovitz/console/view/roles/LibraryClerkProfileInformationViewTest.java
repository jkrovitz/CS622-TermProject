package edu.bu.jkrovitz.console.view.roles;

import edu.bu.jkrovitz.console.view.roles.libraryclerk.LibraryClerkProfileInformationView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for methods in the LibraryClerkProfileInformationView class.
 *
 * @author Jeremy Krovitz
 */
class LibraryClerkProfileInformationViewTest {

    @Test
    void askFirstName() {
        LibraryUserView libraryClerknView = new LibraryClerkProfileInformationView();
        String input = "Jon";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, libraryClerknView.askFirstName());
    }

    @Test
    void askLastName() {
        LibraryUserView libraryClerknView = new LibraryClerkProfileInformationView();
        String input = "Smith";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, libraryClerknView.askLastName());
    }

    @Test
    void askEmailAddress() {
        LibraryUserView libraryClerknView = new LibraryClerkProfileInformationView();
        String input = "test@test.com";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, libraryClerknView.askEmailAddress());
    }

    @Test
    void askUsername() {
        LibraryUserView libraryClerknView = new LibraryClerkProfileInformationView();
        String input = "testuser";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, libraryClerknView.askUsername());
    }

    @Test
    void askPassword() {
        LibraryUserView libraryClerknView = new LibraryClerkProfileInformationView();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, libraryClerknView.askPassword());
    }
}