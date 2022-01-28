package edu.bu.jkrovitz.console.model.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for methods in the Patron class.
 *
 * @author Jeremy Krovitz
 */
class PatronTest {

    @Test
    void testGetFirstName() {
        LibraryUser patron = new Patron();
        String expResult = "Jeremy";
        patron.setFirstName("Jeremy");
        assertEquals(expResult, patron.getFirstName());
    }

    @Test
    void testSetFirstName() {
        String expResult = "Test";
        LibraryUser patron = new Patron();
        patron.setFirstName("Test");
        assertEquals(expResult, patron.getFirstName());
    }

    @Test
    void testGetLastName() {
        LibraryUser patron = new Patron();
        String expResult = "Smith";
        patron.setLastName("Smith");
        assertEquals(expResult, patron.getLastName());
    }

    @Test
    void testSetLastName() {
        String expResult = "User";
        LibraryUser patron = new Patron();
        patron.setLastName("User");
        assertEquals(expResult, patron.getLastName());
    }

    @Test
    void testGetEmailAddress() {
        LibraryUser patron = new Patron();
        String expResult = "test@test.org";
        patron.setEmailAddress("test@test.org");
        assertEquals(expResult, patron.getEmailAddress());
    }

    @Test
    void testSetEmailAddress() {
        String expResult = "testemail@test.com";
        LibraryUser patron = new Patron();
        patron.setEmailAddress("testemail@test.com");
        assertEquals(expResult, patron.getEmailAddress());
    }

    @Test
    void testGetUsername() {
        LibraryUser patronModel = new Patron();
        String expResult = "jsmith";
        patronModel.setUsername("jsmith");
        assertEquals(expResult, patronModel.getUsername());
    }

    @Test
    void testSetUsername() {
        String expResult = "testuser";
        LibraryUser patron = new Patron();
        patron.setUsername("testuser");
        assertEquals(expResult, patron.getUsername());
    }

    @Test
    void testGetPassword() {
        LibraryUser patron = new Patron();
        String expResult = "1234";
        patron.setPassword("1234");
        assertEquals(expResult, patron.getPassword());
    }

    @Test
    void testSetPassword() {
        String expResult = "password";
        LibraryUser patronModel = new Patron();
        patronModel.setPassword("password");
        assertEquals(expResult, patronModel.getPassword());
    }

    @Test
    void testGetEncryptedPassword(){
        LibraryUser patron = new Patron();
        String expResult = "EQUwvw4xRCxyIjpp/i6vYQ==";
        patron.setPassword("1234");
        patron.setEncryptedPassword(patron.getPassword());
        assertEquals(expResult, patron.getEncryptedPassword());
    }

    @Test
    void testSetEncryptedPassword(){
        String expectedResult = "yWSEersQIKl9zjGxNCrPtQ==";
        LibraryUser patron = new Patron();
        patron.setPassword("password");
        patron.setEncryptedPassword(patron.getPassword());
        assertEquals(expectedResult, patron.getEncryptedPassword());
    }
}