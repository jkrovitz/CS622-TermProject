package edu.bu.jkrovitz.console.view.books;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for methods in the BookValidateView class.
 *
 * @author Jeremy Krovitz
 */
class BookValidateViewTest {

    @Test
    void validateBookTitle() {
        assertEquals(true, BookValidateView.validateBookTitle("test"));
        assertEquals(false, BookValidateView.validateBookTitle(""));
        assertEquals(false, BookValidateView.validateBookTitle("testing!!! testing...`12"));
        assertEquals(true, BookValidateView.validateBookTitle("testing testing12"));
    }

    @Test
    void validateAuthor() {
        assertEquals(false, BookValidateView.validateAuthor("John"));
        assertEquals(true, BookValidateView.validateAuthor("John Smith"));
        assertEquals(true, BookValidateView.validateAuthor("John Michael Smith"));
        assertEquals(false, BookValidateView.validateAuthor(""));
    }

    @Test
    void validateYear() {
        assertEquals(true, BookValidateView.validateYear(2002));
        assertEquals(true, BookValidateView.validateYear(2022));
        assertEquals(false, BookValidateView.validateYear(20225));
        assertEquals(false, BookValidateView.validateYear(202));
    }

    @Test
    void validateThirteenDigitISBNNumber() {
        assertEquals(true, BookValidateView.validateThirteenDigitISBNNumber("ISBN 978-0-596-52068-7"));
        assertEquals(true, BookValidateView.validateThirteenDigitISBNNumber("ISBN-13: 978-0-596-52068-7"));
        assertEquals(true, BookValidateView.validateThirteenDigitISBNNumber("978 0 596 52068 7"));
        assertEquals(true, BookValidateView.validateThirteenDigitISBNNumber("9780596520687"));
        assertEquals(false, BookValidateView.validateThirteenDigitISBNNumber("ISBN 11978-0-596-52068-7"));
        assertEquals(false, BookValidateView.validateThirteenDigitISBNNumber("ISBN-12: 978-0-596-52068-7"));
        assertEquals(false, BookValidateView.validateThirteenDigitISBNNumber("978 10 596 52068 7"));
        assertEquals(false, BookValidateView.validateThirteenDigitISBNNumber("119780596520687"));


    }

    @Test
    void validateTenDigitISBNNumber() {
        assertEquals(true, BookValidateView.validateTenDigitISBNNumber("0-596-52068-9"));
        assertEquals(true, BookValidateView.validateTenDigitISBNNumber("0 512 52068 9"));
        assertEquals(true, BookValidateView.validateTenDigitISBNNumber("ISBN-10 0-596-52068-9"));
        assertEquals(true, BookValidateView.validateTenDigitISBNNumber("ISBN-10: 0-596-52068-9"));
        assertEquals(false, BookValidateView.validateTenDigitISBNNumber("0-5961-52068-9"));
        assertEquals(false, BookValidateView.validateTenDigitISBNNumber("11 5122 52068 9"));
        assertEquals(false, BookValidateView.validateTenDigitISBNNumber("ISBN-13 0-596-52068-9"));
        assertEquals(false, BookValidateView.validateTenDigitISBNNumber("ISBN-10- 0-596-52068-9"));
    }
}