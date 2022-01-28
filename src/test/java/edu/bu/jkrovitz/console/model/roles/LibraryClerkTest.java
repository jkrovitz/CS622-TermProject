package edu.bu.jkrovitz.console.model.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for methods in the LibraryClerk class.
 *
 * @author Jeremy Krovitz
 */
class LibraryClerkTest {

    @Test
    void testGetFirstName() {
        LibraryUser libraryClerk = new LibraryClerk();
        String expResult = "Jeremy";
        libraryClerk.setFirstName("Jeremy");
        assertEquals(expResult, libraryClerk.getFirstName());
    }

    @Test
    void testSetFirstName() {
        String expResult = "Test";
        LibraryUser libraryClerk = new LibraryClerk();
        libraryClerk.setFirstName("Test");
        assertEquals(expResult, libraryClerk.getFirstName());
    }

    @Test
    void testGetLastName() {
        LibraryUser libraryClerk = new LibraryClerk();
        String expResult = "Smith";
        libraryClerk.setLastName("Smith");
        assertEquals(expResult, libraryClerk.getLastName());
    }

    @Test
    void testSetLastName() {
        String expResult = "User";
        LibraryUser libraryClerk = new LibraryClerk();
        libraryClerk.setLastName("User");
        assertEquals(expResult, libraryClerk.getLastName());
    }

    @Test
    void testGetEmailAddress() {
        LibraryUser libraryClerk = new LibraryClerk();
        String expResult = "test@test.org";
        libraryClerk.setEmailAddress("test@test.org");
        assertEquals(expResult, libraryClerk.getEmailAddress());
    }

    @Test
    void testSetEmailAddress() {
        String expResult = "testemail@test.com";
        LibraryUser libraryClerk = new LibraryClerk();
        libraryClerk.setEmailAddress("testemail@test.com");
        assertEquals(expResult, libraryClerk.getEmailAddress());
    }

    @Test
    void testGetUsername() {
        LibraryUser libraryClerkModel = new LibraryClerk();
        String expResult = "jsmith";
        libraryClerkModel.setUsername("jsmith");
        assertEquals(expResult, libraryClerkModel.getUsername());
    }

    @Test
    void testSetUsername() {
        String expResult = "testuser";
        LibraryUser libraryClerk = new LibraryClerk();
        libraryClerk.setUsername("testuser");
        assertEquals(expResult, libraryClerk.getUsername());
    }

    @Test
    void testGetPassword() {
        LibraryUser libraryClerk = new LibraryClerk();
        String expResult = "1234";
        libraryClerk.setPassword("1234");
        assertEquals(expResult, libraryClerk.getPassword());
    }

    @Test
    void testSetPassword() {
        String expResult = "password";
        LibraryUser libraryClerkModel = new LibraryClerk();
        libraryClerkModel.setPassword("password");
        assertEquals(expResult, libraryClerkModel.getPassword());
    }

    @Test
    void testGetEncryptedPassword(){
        LibraryUser libraryClerk = new LibraryClerk();
        String expResult = "EQUwvw4xRCxyIjpp/i6vYQ==";
        libraryClerk.setPassword("1234");
        libraryClerk.setEncryptedPassword(libraryClerk.getPassword());
        assertEquals(expResult, libraryClerk.getEncryptedPassword());
    }

    @Test
    void testSetEncryptedPassword(){
        String expectedResult = "yWSEersQIKl9zjGxNCrPtQ==";
        LibraryUser libraryClerk = new LibraryClerk();
        libraryClerk.setPassword("password");
        libraryClerk.setEncryptedPassword(libraryClerk.getPassword());
        assertEquals(expectedResult, libraryClerk.getEncryptedPassword());
    }
}