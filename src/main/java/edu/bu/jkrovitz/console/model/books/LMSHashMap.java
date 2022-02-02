package edu.bu.jkrovitz.console.model.books;

import java.util.ArrayList;
import java.util.HashMap;

public class LMSHashMap<K, V>{

    private HashMap<K, V> theHashMap;

    public LMSHashMap(){
        this.theHashMap = new HashMap<K, V>();
    }

    public HashMap<K, V> setItem(K key, V value){
        this.theHashMap.put(key, value);
        return this.theHashMap;
    }

    public HashMap<K, V> getHashMap(){
        return this.theHashMap;
    }
}
