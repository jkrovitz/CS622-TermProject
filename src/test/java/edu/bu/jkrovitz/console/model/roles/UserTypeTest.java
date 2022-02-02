package edu.bu.jkrovitz.console.model.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for methods in the UserType class.
 *
 * @author Jeremy Krovitz
 */
class UserTypeTest<T> {

    @Test
    void testGetFirstName() {
        LibraryUser userType = new UserType<T>();
        String expResult = "Jeremy";
        userType.setFirstName("Jeremy");
        assertEquals(expResult, userType.getFirstName());
    }

    @Test
    void testSetFirstName() {
        String expResult = "Test";
        LibraryUser userType = new UserType<T>();
        userType.setFirstName("Test");
        assertEquals(expResult, userType.getFirstName());
    }

    @Test
    void testGetLastName() {
        LibraryUser userType = new UserType<T>();
        String expResult = "Smith";
        userType.setLastName("Smith");
        assertEquals(expResult, userType.getLastName());
    }

    @Test
    void testSetLastName() {
        String expResult = "User";
        LibraryUser userType = new UserType<T>();
        userType.setLastName("User");
        assertEquals(expResult, userType.getLastName());
    }

    @Test
    void testGetEmailAddress() {
        LibraryUser userType = new UserType<T>();
        String expResult = "test@test.org";
        userType.setEmailAddress("test@test.org");
        assertEquals(expResult, userType.getEmailAddress());
    }

    @Test
    void testSetEmailAddress() {
        String expResult = "testemail@test.com";
        LibraryUser userType = new UserType<T>();
        userType.setEmailAddress("testemail@test.com");
        assertEquals(expResult, userType.getEmailAddress());
    }

    @Test
    void testGetUsername() {
        LibraryUser libraryClerkModel = new UserType<T>();
        String expResult = "jsmith";
        libraryClerkModel.setUsername("jsmith");
        assertEquals(expResult, libraryClerkModel.getUsername());
    }

    @Test
    void testSetUsername() {
        String expResult = "testuser";
        LibraryUser userType = new UserType();
        userType.setUsername("testuser");
        assertEquals(expResult, userType.getUsername());
    }

    @Test
    void testGetPassword() {
        LibraryUser userType = new UserType();
        String expResult = "1234";
        userType.setPassword("1234");
        assertEquals(expResult, userType.getPassword());
    }

    @Test
    void testSetPassword() {
        String expResult = "password";
        LibraryUser libraryClerkModel = new UserType();
        libraryClerkModel.setPassword("password");
        assertEquals(expResult, libraryClerkModel.getPassword());
    }

    @Test
    void testGetEncryptedPassword(){
        LibraryUser userType = new UserType();
        String expResult = "EQUwvw4xRCxyIjpp/i6vYQ==";
        userType.setPassword("1234");
        userType.setEncryptedPassword(userType.getPassword());
        assertEquals(expResult, userType.getEncryptedPassword());
    }

    @Test
    void testSetEncryptedPassword(){
        String expectedResult = "yWSEersQIKl9zjGxNCrPtQ==";
        LibraryUser userType = new UserType();
        userType.setPassword("password");
        userType.setEncryptedPassword(userType.getPassword());
        assertEquals(expectedResult, userType.getEncryptedPassword());
    }
}