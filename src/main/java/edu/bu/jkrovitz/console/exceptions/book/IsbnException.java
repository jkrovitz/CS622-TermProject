package edu.bu.jkrovitz.console.exceptions.book;

import edu.bu.jkrovitz.console.view.books.BookValidateView;

public class IsbnException extends Exception{

    public IsbnException(){
        super ("The ISBN is formatted incorrectly.");
    }

    public IsbnException(String errorMessage){
        super(errorMessage);

    }
}
