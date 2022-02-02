package edu.bu.jkrovitz.console.model.books;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in the LMSHashMap class.
 */
class LMSHashMapTest {

    @Test
    void setStringKeyDoubleValueItem() {
       LMSHashMap<String, Double> stringDoubleHashMap = new LMSHashMap<>();
       assertEquals(0, stringDoubleHashMap.getHashMap().size());
       assertTrue(stringDoubleHashMap.setItem("first double", 2.3).containsKey("first double"));
       assertTrue(stringDoubleHashMap.setItem("second double", 4.4).containsValue(2.3));
       assertFalse(stringDoubleHashMap.setItem("third double", 6.2).containsKey("fourth double"));
    }

    @Test
    void setIntegerKeyBookValueItem(){
        LMSHashMap<Integer, Book> integerBookHashMap = new LMSHashMap<>();
        assertEquals(0, integerBookHashMap.getHashMap().size());
        Book sampleBook = new Book(
                "Frankenstein",
                "Mary Shelley",
                1994,
                "Dover Publications",
                166,
                "The story of Victor Frankenstein's " +
                        "terrible creation and the havoc it caused " +
                        "has enthralled generations of readers and " +
                        "inspired countless writers of horror and " +
                        "suspense.",
                "ISBN-13: 978-0-486-28211-4",
                "ISBN-10: 0-486-28211-4",
                1,
                1);
        assertTrue(integerBookHashMap.setItem(1, sampleBook).containsKey(1));
        Book sampleBook2 = new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                2021,
                "Independently published",
                123,
                "The Great Gatsby is a 1925 novel " +
                        "by American writer F. Scott Fitzgerald. " +
                        "Set in the Jazz Age on Long Island, the " +
                        "novel depicts narrator Nick Carraway's " +
                        "interactions with mysterious millionaire " +
                        "Jay Gatsby, and Gatsby's obsession to reunite " +
                        "with his former lover, Daisy Buchanan.",
                "979-8-581-48423-4",
                "8-581-48423-4",
                1,
                1);
        assertTrue(integerBookHashMap.setItem(2, sampleBook2).containsValue(sampleBook));
        assertFalse(integerBookHashMap.setItem(3, sampleBook).containsKey(4));
    }

    @Test
    void getStringKeyDoubleValueHashmap() {
        LMSHashMap<String, Double> stringDoubleHashMap = new LMSHashMap<>();
        assertEquals(0, stringDoubleHashMap.getHashMap().size());
        stringDoubleHashMap.setItem("first double", 2.3);
        assertTrue(stringDoubleHashMap.getHashMap().containsKey("first double"));
        assertTrue(stringDoubleHashMap.getHashMap().containsValue(2.3));
        assertFalse(stringDoubleHashMap.getHashMap().containsKey("fourth double"));
    }

    @Test
    void getIntegerKeyBookValueItem(){
        LMSHashMap<Integer, Book> integerBookHashMap = new LMSHashMap<>();
        assertEquals(0, integerBookHashMap.getHashMap().size());
        Book sampleBook = new Book(
                "Frankenstein",
                "Mary Shelley",
                1994,
                "Dover Publications",
                166,
                "The story of Victor Frankenstein's " +
                        "terrible creation and the havoc it caused " +
                        "has enthralled generations of readers and " +
                        "inspired countless writers of horror and " +
                        "suspense.",
                "ISBN-13: 978-0-486-28211-4",
                "ISBN-10: 0-486-28211-4",
                1,
                1);
        integerBookHashMap.setItem(1, sampleBook);
        assertTrue(integerBookHashMap.getHashMap().containsKey(1));
        assertTrue(integerBookHashMap.getHashMap().containsValue(sampleBook));
        assertFalse(integerBookHashMap.getHashMap().containsKey(4));
    }

}