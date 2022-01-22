package edu.bu.jkrovitz.console.model.roles;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibrarianModel extends LibraryUserModel{

    String firstName;
    String lastName;
    String emailAddress;
    String username;
    String password;
    String employeeId;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void createRole(String firstName, String lastName, String emailAddress, String username, String password) {
        Path root = Paths.get(".").normalize().toAbsolutePath();
        String librarianFile = root + "/src/edu/bu/jkrovitz/console/csvs/librarian.csv";
        String[] columnHeaders = {"first name", "last name", "email address", "username", "password", "employee id"};
        try {
            FileWriter csvWriter = new FileWriter(librarianFile, true);
            File file = new File(librarianFile);

            if (file.length() == 0) {

                for (String columnHeader : columnHeaders) {
                    csvWriter.append(columnHeader + ", ");
                }
            }
            csvWriter.append("\n" + firstName + ", " + lastName + ", " + emailAddress + ", " + username + ", " + password +  ", " + employeeId + ", ");

            csvWriter.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
