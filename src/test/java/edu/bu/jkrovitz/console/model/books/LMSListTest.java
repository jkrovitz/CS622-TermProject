package edu.bu.jkrovitz.console.model.books;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in the LMSList class.
 */
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

    @Test
    void setFirstIntegerItem(){
        LMSList<Integer> integerList = new LMSList<>();
        integerList.getList().add(1);
        integerList.getList().add(2);
        assertEquals(5, integerList.setFirstItem(5));
        integerList.setFirstItem(6);
        assertEquals(6, integerList.getFirstItem());
        integerList.getList().add(0, 7);
        assertEquals(7, integerList.getFirstItem());
    }

    @Test
    void setFirstStringItem(){
        LMSList<String> stringList = new LMSList<>();
        stringList.getList().add("Frankenstein");
        stringList.getList().add("Red Kayak");
        assertEquals("The Great Gatsby", stringList.setFirstItem("The Great Gatsby"));
        stringList.setFirstItem("To Kill A Mockingbird");
        assertEquals("To Kill A Mockingbird", stringList.getFirstItem());
        stringList.getList().add(0, "Better Nate Than Ever");
        assertEquals("Better Nate Than Ever", stringList.getFirstItem());
    }

    @Test
    void setFirstDoubleItem(){
        LMSList<Double> doubleList = new LMSList<>();
        doubleList.getList().add(2.3);
        doubleList.getList().add(5.2);
        assertEquals(8.6, doubleList.setFirstItem(8.6));
        doubleList.setFirstItem(10.7);
        assertEquals(10.7, doubleList.getFirstItem());
        doubleList.getList().add(0, 4.2);
        assertEquals(4.2, doubleList.getFirstItem());
    }

    @Test
    void setFirstBooleanItem(){
        LMSList<Boolean> booleanList = new LMSList<>();
        booleanList.getList().add(true);
        booleanList.getList().add(false);
        assertEquals(true, booleanList.setFirstItem(true));
        booleanList.setFirstItem(false);
        assertEquals(false, booleanList.getFirstItem());
        booleanList.getList().add(0, true);
        assertEquals(true, booleanList.getFirstItem());
    }
    
    @Test
    void getFirstIntegerItem(){
        LMSList<Integer> integerList = new LMSList<>();
        integerList.getList().add(34);
        integerList.getList().add(31);
        integerList.getList().add(0, 28);
        assertEquals(28, integerList.getFirstItem());
        integerList.setFirstItem(3);
        assertEquals(3, integerList.getFirstItem());
    }

    @Test
    void getFirstStringItem(){
        LMSList<String> stringList = new LMSList<>();
        stringList.getList().add("Frankenstein");
        stringList.getList().add("To Kill A Mockingbird");
        stringList.getList().add(0, "The Great Gatsby");
        assertEquals("The Great Gatsby", stringList.getFirstItem());
        stringList.setFirstItem("Better Nate Than Ever");
        assertEquals("Better Nate Than Ever", stringList.getFirstItem());
    }

    @Test
    void setLastDoubleItem(){
        LMSList<Double> doubleList = new LMSList<>();
        doubleList.getList().add(3.2);
        doubleList.getList().add(4.3);
        assertEquals(5.2, doubleList.setLastItem(5.2));
        doubleList.setLastItem(7.2);
        doubleList.setLastItem(8.3);
        assertEquals(8.3, doubleList.getLastItem());
        doubleList.getList().add((doubleList.getList().size()), 4.7);
        assertEquals(4.7, doubleList.getLastItem());
    }

    @Test
    void setLastStringItem(){
        LMSList<String> stringList = new LMSList<>();
        stringList.getList().add("Frankenstein");
        stringList.getList().add("The Great Gasby");
        assertEquals("To Kill A Mockingbird", stringList.setLastItem("To Kill A Mockingbird"));
        stringList.setLastItem("Better Nate Than Ever");
        stringList.setLastItem("Me and Earl and the Dying Girl");
        assertEquals("Me and Earl and the Dying Girl", stringList.getLastItem());
        stringList.getList().add((stringList.getList().size()), "Fun Home");
        assertEquals("Fun Home", stringList.getLastItem());
    }

    @Test
    void getLastIntegerItem(){
        LMSList<Integer> integerList = new LMSList<>();
        integerList.getList().add(34);
        integerList.getList().add(31);
        integerList.getList().add(integerList.getList().size(), 28);
        assertEquals(28, integerList.getLastItem());
        integerList.setLastItem(3);
        assertEquals(3, integerList.getLastItem());
    }

    @Test
    void getLastStringItem(){
        LMSList<String> stringList = new LMSList<>();
        stringList.getList().add("Frankenstein");
        stringList.getList().add("To Kill A Mockingbird");
        stringList.getList().add(stringList.getList().size(), "The Great Gatsby");
        assertEquals("The Great Gatsby", stringList.getLastItem());
        stringList.setLastItem("Better Nate Than Ever");
        assertEquals("Better Nate Than Ever", stringList.getLastItem());
    }
}