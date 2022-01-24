package edu.bu.jkrovitz.console.view.roles;

import java.util.Scanner;

public class LibraryClerkView extends LibraryUserView {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;
    private String employeeId;
    private String roleType;

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

    @Override
    public String askRoleType(){
        roleType = super.askRoleType();
        return roleType;
    }

//    public String askEmployeeId(){
//        Scanner personInput = new Scanner(System.in);
//        System.out.println("Please enter an id for the librarian");
//        int libraryClerkIntId = personInput.nextInt();
//        employeeId = "LC" + libraryClerkIntId;
//        return employeeId;
//    }
}
