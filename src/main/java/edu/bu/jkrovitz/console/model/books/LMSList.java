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

    public T setFirstItem(T input){
        this.theList.add(0, input);
        return this.theList.get(0);
    }

    public T getFirstItem(){
        return this.theList.get(0);
    }

    public T setLastItem(T input){
        this.theList.add(input);
        return this.theList.get(this.theList.size()-1);
    }

    public T getLastItem() {
        return this.theList.get(this.theList.size()-1);
    }

    // I might consider adding the count, the first and the last item in the list; use a data type otehr than an array list
}
