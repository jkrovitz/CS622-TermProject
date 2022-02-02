package edu.bu.jkrovitz.console.model.books;

import junit.framework.Assert;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LMSListTest {

    @Test
    void setItemIntegers() {
        LMSList<Integer> integerList = new LMSList<Integer>();
        assertEquals(0, integerList.getList().size());
        integerList.setItem(1);
        assertEquals(1, integerList.getList().size());
        integerList.setItem(10);
        integerList.setItem(20);
        integerList.setItem(30);
        assertEquals(4, integerList.getList().size());
    }

    @Test
    void setItemString(){
        LMSList<String> stringList = new LMSList<>();
        assertTrue(stringList.getList().isEmpty());
        stringList.setItem("The Passing Playbook");
        assertFalse(stringList.getList().isEmpty());
        assertTrue(stringList.getList().contains("The Passing Playbook"));
        stringList.setItem("Lawn Boy");
        assertTrue(stringList.getList().contains("Lawn Boy"));
        assertTrue(stringList.getList().contains("The Passing Playbook"));
    }

    @Test
    void setItemDouble(){
        LMSList<Double> doubleList = new LMSList<>();
        assertTrue(doubleList.getList().isEmpty());
        doubleList.setItem(3.23);
        assertTrue(doubleList.getList().contains(3.23));
        assertFalse(doubleList.getList().contains(5.2));
        assertEquals(1, doubleList.getList().size());
    }

    @Test
    void setItemBoolean(){
        LMSList<Boolean> booleanList = new LMSList<>();
        assertTrue(booleanList.getList().isEmpty());
        booleanList.setItem(true);
        assertTrue(booleanList.getList().contains(true));
        assertFalse(booleanList.getList().contains(false));
        booleanList.setItem(false);
        assertTrue(booleanList.getList().contains(false));
        booleanList.setItem(false);
        assertTrue(booleanList.getList().contains(true));
    }

    @Test
    void setBookList(){
        LMSList<Book> bookList = new LMSList<>();
        assertTrue(bookList.getList().isEmpty());
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
        bookList.setItem(sampleBook);
        assertTrue(EqualsBuilder.reflectionEquals(sampleBook, bookList.getList().get(0)));
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
        bookList.setItem(sampleBook2);
        assertFalse(EqualsBuilder.reflectionEquals(sampleBook, bookList.getList().get(1)));
    }

    @Test
    void getIntegerList(){
        LMSList<Integer> integerList = new LMSList<>();
        assertTrue(integerList.getList().isEmpty());
        assertEquals(1, integerList.setItem(3).size());
        assertEquals(2, integerList.setItem(5).size());
    }

    @Test
    void getStringList() {
        LMSList<String> stringList = new LMSList<>();
        assertTrue(stringList.getList().isEmpty());
        assertTrue(stringList.setItem("Better Nate Than Ever").contains("Better Nate Than Ever"));
        assertTrue(stringList.getList().contains("Better Nate Than Ever"));
    }

    @Test
    void getDoubleList() {
        LMSList<Double> doubleList = new LMSList<>();
        assertTrue(doubleList.getList().isEmpty());
        assertTrue(doubleList.setItem(2.3).contains(2.3));
        assertEquals(2, doubleList.setItem(2.2).size());
        assertTrue(doubleList.getList().contains(2.2));
    }

    @Test
    void getBooleanList(){
        LMSList<Boolean> booleanList = new LMSList<>();
        assertTrue(booleanList.getList().isEmpty());
        assertFalse(booleanList.setItem(true).contains(false));
        assertTrue(booleanList.setItem(false).contains(false));
        assertEquals(2, booleanList.getList().size());
    }

    @Test
    void getBookList(){
        LMSList<Book> bookList = new LMSList<>();
        assertTrue(bookList.getList().isEmpty());
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
        assertTrue(EqualsBuilder.reflectionEquals(sampleBook, bookList.setItem(sampleBook).get(0)));
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
        assertFalse(EqualsBuilder.reflectionEquals(sampleBook, bookList.setItem(sampleBook2).get(1)));
    }
}