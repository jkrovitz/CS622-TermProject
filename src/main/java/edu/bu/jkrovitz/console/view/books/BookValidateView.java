package edu.bu.jkrovitz.console.view.books;

public class BookValidateView {

    public static boolean validateBookTitle(String title){
        return title.matches("^\\w++(?:[.,_:()\\s-](?![.\\s-])|\\w++)*$");
    }

    public static boolean validateYear(int year){
        return String.valueOf(year).matches("\\d{4}");
    }

    public static boolean validateThirteenDigitISBNNumber(String thirteenDigitISBN){
       return thirteenDigitISBN.matches("^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$"); // Obtained and modified regex from https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/
    }

    public static boolean validateTenDigitISBNNumber(String tenDigitISBN) {
        return tenDigitISBN.matches("^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$"); // Obtained and modified regex from https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/
    }
}
