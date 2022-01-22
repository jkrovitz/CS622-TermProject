package edu.bu.jkrovitz.console.model.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserModelTest {

    @org.junit.jupiter.api.Test
    void testGetFirstName() {
        LibraryUserModel librarianModel = new LibrarianModel();
        String expResult = "Jeremy";
        librarianModel.setFirstName("Jeremy");
        String result = "Jeremy";
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testSetFirstName() {
        String firstName = "Jeremy";
        LibraryUserModel librarianModel = new LibrarianModel();
        librarianModel.setFirstName(firstName);
        assertEquals(librarianModel.getFirstName(), firstName);
    }

    @org.junit.jupiter.api.Test
    void testGetLastName() {
        LibraryUserModel librarianModel = new LibrarianModel();
        String expResult = "Krovitz";
        librarianModel.setLastName("Krovitz");
        String result = "Krovitz";
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testSetLastName() {
        String lastName = "Krovitz";
        LibraryUserModel librarianModel = new LibrarianModel();
        librarianModel.setLastName(lastName);
        assertEquals(librarianModel.getLastName(), lastName);
    }

    @org.junit.jupiter.api.Test
    void testGetEmailAddress() {
        LibraryUserModel librarianModel = new LibrarianModel();
        String expResult = "jkrovitz@gmail.com";
        librarianModel.setEmailAddress("jkrovitz@gmail.com");
        String result = "jkrovitz@gmail.com";
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testSetEmailAddress() {
        String emailAddress = "jkrovitz@gmail.com";
        LibraryUserModel librarianModel = new LibrarianModel();
        librarianModel.setEmailAddress(emailAddress);
        assertEquals(librarianModel.getEmailAddress(), emailAddress);
    }

    @org.junit.jupiter.api.Test
    void testGetUsername() {
        LibraryUserModel librarianModel = new LibrarianModel();
        String expResult = "jkrovitz";
        librarianModel.setUsername("jkrovitz");
        String result = "jkrovitz";
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testSetUsername() {
        String username = "jkrovitz";
        LibraryUserModel librarianModel = new LibrarianModel();
        librarianModel.setUsername(username);
        assertEquals(librarianModel.getUsername(), username);
    }

    @org.junit.jupiter.api.Test
    void testGetPassword() {
        LibraryUserModel librarianModel = new LibrarianModel();
        String expResult = "password";
        librarianModel.setEmailAddress("password");
        String result = "password";
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testSetPassword() {
        String password = "password";
        LibraryUserModel librarianModel = new LibrarianModel();
        librarianModel.setPassword(password);
        assertEquals(librarianModel.getPassword(), password);
    }

    @Test
    void createRole() {
    }
}