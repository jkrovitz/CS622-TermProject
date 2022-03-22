package edu.bu.jkrovitz.console.model.books;

public class AuthorStringManipulation {

    public String[] createAuthorArray(String author){
       return author.split(" ");
    }
}
