package edu.bu.jkrovitz.console.exceptions.book;

import edu.bu.jkrovitz.console.view.books.BookValidateView;

public class IsbnException extends Exception{

    private String isbn;

    public IsbnException(){

    }

    public IsbnException(String message){
        super(message);
    }

    public boolean invalidIsbn() {
        if ((!(BookValidateView.validateThirteenDigitISBNNumber(isbn))) && (!(BookValidateView.validateTenDigitISBNNumber(isbn)))) {
            System.out.println("\nThe input is invalid ISBN number formatting.");
            return true;
        }
        return false;
    }
}
