package edu.bu.jkrovitz.console.view.roles;

import java.util.Scanner;

public class LibraryClerkView extends LibraryUserView {
    String firstName;
    String lastName;
    String emailAddress;
    String username;
    String password;
    String employeeId;

    @Override
    public String askFirstName(){
        firstName = super.askFirstName();
        return firstName;
    }

    @Override
    public String askLastName() {
        lastName = super.askLastName();
        return lastName;
    }

    @Override
    public String askEmailAddress() {
        emailAddress = super.askEmailAddress();
        return emailAddress;
    }

    @Override
    public String askUsername() {
        username = super.askUsername();
        return username;
    }

    @Override
    public String askPassword(){
        password = super.askPassword();
        return password;
    }

    public String askEmployeeId(){
        Scanner personInput = new Scanner(System.in);
        System.out.println("Please enter an id for the librarian");
        int libraryClerkIntId = personInput.nextInt();
        employeeId = "LC" + libraryClerkIntId;
        return employeeId;
    }
}
