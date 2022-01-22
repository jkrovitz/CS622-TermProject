package edu.bu.jkrovitz.console.view.roles;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibrarianViewTest {

    @org.junit.jupiter.api.Test
    void askFirstName() {
        LibraryUserView librarianView = new LibrarianView();
        String input = "Jeremy";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Jeremy", librarianView.askFirstName());
    }

    @org.junit.jupiter.api.Test
    void askLastName() {
        LibraryUserView librarianView = new LibrarianView();
        String input = "Krovitz";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Krovitz", librarianView.askLastName());
    }

    @org.junit.jupiter.api.Test
    void askEmailAddress() {
        LibraryUserView librarianView = new LibrarianView();
        String input = "jkrovitz@bu.edu";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("jkrovitz@bu.edu", librarianView.askEmailAddress());
    }

    @org.junit.jupiter.api.Test
    void askUsername() {
        LibraryUserView librarianView = new LibrarianView();
        String input = "jkrovitz";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("jkrovitz", librarianView.askUsername());
    }

    @org.junit.jupiter.api.Test
    void askPassword() {
        LibraryUserView librarianView = new LibrarianView();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("1234", librarianView.askPassword());
    }

    @org.junit.jupiter.api.Test
    void askEmployeeId() {
        LibrarianView librarianView = new LibrarianView();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("L1234", librarianView.askEmployeeId());
    }
}
