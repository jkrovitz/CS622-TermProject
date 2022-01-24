package edu.bu.jkrovitz.console.view;

import java.util.Scanner;

public class LoginView {

    public String enterUsername(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username.");
        return sc.nextLine();
    }

    public String enterPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password.");
        return sc.nextLine();
    }
}
