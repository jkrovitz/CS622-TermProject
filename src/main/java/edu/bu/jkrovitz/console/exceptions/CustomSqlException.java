package edu.bu.jkrovitz.console.exceptions;

import java.sql.SQLException;

public class CustomSqlException extends SQLException {

    public CustomSqlException(String message) {
        super(message);
    }

    public void printExceptionMessage(String exceptionMessage){
        System.out.println(exceptionMessage);
    }
}
