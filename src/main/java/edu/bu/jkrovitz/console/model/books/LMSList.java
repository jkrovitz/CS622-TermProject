package edu.bu.jkrovitz.console.model.books;

import java.util.ArrayList;

public class LMSList<T>{

    private ArrayList<T> theList;

    public LMSList(){
        this.theList = new ArrayList<T>();
    }

    public ArrayList<T> setItem(T input){
        this.theList.add(input);
        return this.theList;
    }

    public ArrayList<T> getList(){
        return this.theList;
    }

    // I might consider adding the count, the first and the last item in the list; use a data type otehr than an array list
}
