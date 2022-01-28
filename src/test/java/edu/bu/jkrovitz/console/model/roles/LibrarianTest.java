package edu.bu.jkrovitz.console.model.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for methods in the Librarian class.
 *
 * @author Jeremy Krovitz
 */
class LibrarianTest extends LibraryUserTest {

    @Test
    void testGetFirstName() {
        LibraryUser librarian = new Librarian();
        String expResult = "Jeremy";
        librarian.setFirstName("Jeremy");
        assertEquals(expResult, librarian.getFirstName());
    }

    @Test
    void testSetFirstName() {
        String expResult = "Test";
        LibraryUser librarian = new Librarian();
        librarian.setFirstName("Test");
        assertEquals(expResult, librarian.getFirstName());
    }

    @Test
    void testGetLastName() {
        LibraryUser librarian = new Librarian();
        String expResult = "Smith";
        librarian.setLastName("Smith");
        assertEquals(expResult, librarian.getLastName());
    }

    @Test
    void testSetLastName() {
        String expResult = "User";
        LibraryUser librarian = new Librarian();
        librarian.setLastName("User");
        assertEquals(expResult, librarian.getLastName());
    }

    @Test
    void testGetEmailAddress() {
        LibraryUser librarian = new Librarian();
        String expResult = "test@test.org";
        librarian.setEmailAddress("test@test.org");
        assertEquals(expResult, librarian.getEmailAddress());
    }

    @Test
    void testSetEmailAddress() {
        String expResult = "testemail@test.com";
        LibraryUser librarian = new Librarian();
        librarian.setEmailAddress("testemail@test.com");
        assertEquals(expResult, librarian.getEmailAddress());
    }

    @Test
    void testGetUsername() {
        LibraryUser librarianModel = new Librarian();
        String expResult = "jsmith";
        librarianModel.setUsername("jsmith");
        assertEquals(expResult, librarianModel.getUsername());
    }

    @Test
    void testSetUsername() {
        String expResult = "testuser";
        LibraryUser librarian = new Librarian();
        librarian.setUsername("testuser");
        assertEquals(expResult, librarian.getUsername());
    }

    @Test
    void testGetPassword() {
        LibraryUser librarian = new Librarian();
        String expResult = "1234";
        librarian.setPassword("1234");
        assertEquals(expResult, librarian.getPassword());
    }

    @Test
    void testSetPassword() {
        String expResult = "password";
        LibraryUser librarianModel = new Librarian();
        librarianModel.setPassword("password");
        assertEquals(expResult, librarianModel.getPassword());
    }

    @Test
    void testGetEncryptedPassword() {
        LibraryUser librarian = new Librarian();
        String expResult = "EQUwvw4xRCxyIjpp/i6vYQ==";
        librarian.setPassword("1234");
        librarian.setEncryptedPassword(librarian.getPassword());
        assertEquals(expResult, librarian.getEncryptedPassword());
    }

    @Test
    void testSetEncryptedPassword() {
        String expectedResult = "yWSEersQIKl9zjGxNCrPtQ==";
        LibraryUser librarian = new Librarian();
        librarian.setPassword("password");
        librarian.setEncryptedPassword(librarian.getPassword());
        assertEquals(expectedResult, librarian.getEncryptedPassword());
    }
}