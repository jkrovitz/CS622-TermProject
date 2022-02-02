package edu.bu.jkrovitz.console.model.books;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookFileModelTest {

    @TempDir
    Path tempDir = Paths.get(("./src/test/java/TempDir"));

    private Book book;
    private File file;
    private FileWriter fileWriter;
    private Gson gson;
    private Path path;

    @BeforeEach
    void setUp() {
        //Any other fields that are going to be reused should go in here
        path = tempDir.resolve(tempDir + "booktest.json");
        file = new File(String.valueOf(path));
//        book = new Book("Frankenstein", "Mary Shelley", 1994, "Dover Publications, Inc.", 166, "The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.", "ISBN-13: 978-0-486-28211-4", "ISBN-10: 0-486-28211-4", 1, 1);
//        file = null;
//        fileWriter = null;
//        gson = null;
//        PrintWriter printWriter = null;
//        try {
//            printWriter = new PrintWriter("./src/test/resources/edu.bu.jkrovitz/csvs/books.csv");
//            printWriter.write("");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    @AfterEach
    void tearDown() {
        //clean up the file by closing it and making sure that the operating system deletes it.
    }



//File that serves as base that changes - already doing this
    //File should be written out to temporary file
    //Make sure when the test runs that the file gets into the same state
    @Test
    void testAddBookToFile() {
        BookFileModel bookFileModel = new BookFileModel();
        try (FileWriter fileWriter = new FileWriter(String.valueOf(path), true)) {
            String jsonString = bookFileModel.addToBookFile(path.toString(), "Frankenstein", "Mary Shelley", 1994, "Dover Publications", 166, "The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.", "ISBN-13: 978-0-486-28211-4", "ISBN-10: 0-486-28211-4", 1, 1);
            String expected = "{\"title\":\"Frankenstein\",\"author\":\"Mary Shelley\",\"year\":1994,\"publisher\":\"Dover Publications\",\"pages\":166,\"briefDescription\":\"The story of Victor Frankenstein\\u0027s terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.\",\"thirteenDigitISBN\":\"ISBN-13: 978-0-486-28211-4\",\"tenDigitISBN\":\"ISBN-10: 0-486-28211-4\",\"copies\":1,\"quantityAvailable\":1}";
            assertEquals(expected, jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAddBookToEmptyFile(){
        Gson gson = null;
        BookFileModel bookFileModel = new BookFileModel();
        Book book = null;
//        Path path = tempDir.resolve(tempDir + "booktest.json");
//        File file = new File(String.valueOf(path));
//        NullPointerException npe = null;
//        String expectedErrorMessage = npe.getMessage();

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            gson = new Gson();
            if (file.length() == 0){
                book = new Book("Frankenstein", "Mary Shelley", 1994, "Dover Publications", 166, "The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.", "ISBN-13: 978-0-486-28211-4", "ISBN-10: 0-486-28211-4", 1, 1);
                Gson returnedGson = bookFileModel.addBookToEmptyFile(gson, book, fileWriter);
                String bookString = returnedGson.toJson(book);
                String expected = "{\"title\":\"Frankenstein\",\"author\":\"Mary Shelley\",\"year\":1994,\"publisher\":\"Dover Publications\",\"pages\":166,\"briefDescription\":\"The story of Victor Frankenstein\\u0027s terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.\",\"thirteenDigitISBN\":\"ISBN-13: 978-0-486-28211-4\",\"tenDigitISBN\":\"ISBN-10: 0-486-28211-4\",\"copies\":1,\"quantityAvailable\":1}";
                assertEquals(expected, bookString);

            }
        } catch (NullPointerException npe) {
            assertEquals("(No such file or directory)", npe.getMessage());
        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        //Use assertThrows for exceptions
        // Put each exception in a different test
        // Write get first and get last function
    }

//        @ParameterizedTest
//    @CsvFileSource(resources = "/edu.bu.jkrovitz/csvs/books.csv", numLinesToSkip = 1)
//    void testWriteCsvData(String title, String author, String year, String published, String pages, String briefDescription, String thirteenDigitIsbn, String tenDigitIsbn, String copies, String quantityAvailable){
//        assertEquals("Frankenstein", title);
//        assertEquals("Mary Shelley", author);
//        assertEquals(1994, Integer.valueOf(year));
//        assertEquals("Dover Publications", published);
//
//
//    }

//    @Test
//    void testAddToBookFile() {
//        BookFileModel bookFileModel = new BookFileModel();
//        Path path = tempDir.resolve(tempDir + "booktest.json");
//        try(FileWriter fileWriter = new FileWriter(String.valueOf(path), true)){
//            Gson gson = bookFileModel.addToBookFile("Frankenstein", "Mary Shelley", 1994, "Dover Publications", 166, "The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.", "ISBN-13: 978-0-486-28211-4", "ISBN-10: 0-486-28211-4", 1, 1);
////            String expectedResult = "[\n" +
////                    "  {\n" +
////                    "    \"title\": \"Frankenstein\",\n" +
////                    "    \"author\": \"Mary Shelley\",\n" +
////                    "    \"year\": 1994,\n" +
////                    "    \"publisher\": \"Dover Publications\",\n" +
////                    "    \"pages\": 166,\n" +
////                    "    \"briefDescription\": \"The story of Victor Frankenstein\\u0027s terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.\",\n" +
////                    "    \"thirteenDigitISBN\": \"ISBN-13: 978-0-486-28211-4\",\n" +
////                    "    \"tenDigitISBN\": \"ISBN-10: 0-486-28211-4\",\n" +
////                    "    \"copies\": 1,\n" +
////                    "    \"quantityAvailable\": 1\n" +
////                    "  }\n" +
////                    "]";
//            String expectedResult = "{serializeNulls:false,factories:[Factory[typeHierarchy=com.google.gson.JsonElement,adapter=com.google.gson.internal.bind.TypeAdapters$27@2aece37d], com.google.gson.internal.bind.ObjectTypeAdapter$1@548a102f, com.google.gson.internal.Excluder@5762806e, Factory[type=java.lang.String,adapter=com.google.gson.internal.bind.TypeAdapters$15@17c386de], Factory[type=java.lang.Integer+int,adapter=com.google.gson.internal.bind.TypeAdapters$7@5af97850], Factory[type=java.lang.Boolean+boolean,adapter=com.google.gson.internal.bind.TypeAdapters$3@5ef60048], Factory[type=java.lang.Byte+byte,adapter=com.google.gson.internal.bind.TypeAdapters$5@1d548a08], Factory[type=java.lang.Short+short,adapter=com.google.gson.internal.bind.TypeAdapters$6@16aa0a0a], Factory[type=java.lang.Long+long,adapter=com.google.gson.internal.bind.TypeAdapters$11@780cb77], Factory[type=java.lang.Double+double,adapter=com.google.gson.Gson$1@691a7f8f], Factory[type=java.lang.Float+float,adapter=com.google.gson.Gson$2@50a7bc6e], com.google.gson.internal.bind.NumberTypeAdapter$1@161b062a, Factory[type=java.util.concurrent.atomic.AtomicInteger,adapter=com.google.gson.TypeAdapter$1@17c1bced], Factory[type=java.util.concurrent.atomic.AtomicBoolean,adapter=com.google.gson.TypeAdapter$1@2d9d4f9d], Factory[type=java.util.concurrent.atomic.AtomicLong,adapter=com.google.gson.TypeAdapter$1@4034c28c], Factory[type=java.util.concurrent.atomic.AtomicLongArray,adapter=com.google.gson.TypeAdapter$1@e50a6f6], Factory[type=java.util.concurrent.atomic.AtomicIntegerArray,adapter=com.google.gson.TypeAdapter$1@14ec4505], Factory[type=java.lang.Character+char,adapter=com.google.gson.internal.bind.TypeAdapters$14@53ca01a2], Factory[type=java.lang.StringBuilder,adapter=com.google.gson.internal.bind.TypeAdapters$18@358c99f5], Factory[type=java.lang.StringBuffer,adapter=com.google.gson.internal.bind.TypeAdapters$19@3ee0fea4], Factory[type=java.math.BigDecimal,adapter=com.google.gson.internal.bind.TypeAdapters$16@48524010], Factory[type=java.math.BigInteger,adapter=com.google.gson.internal.bind.TypeAdapters$17@4b168fa9], Factory[type=java.net.URL,adapter=com.google.gson.internal.bind.TypeAdapters$20@1a84f40f], Factory[type=java.net.URI,adapter=com.google.gson.internal.bind.TypeAdapters$21@23282c25], Factory[type=java.util.UUID,adapter=com.google.gson.internal.bind.TypeAdapters$23@7920ba90], Factory[type=java.util.Currency,adapter=com.google.gson.TypeAdapter$1@6b419da], Factory[type=java.util.Locale,adapter=com.google.gson.internal.bind.TypeAdapters$26@3b2da18f], Factory[typeHierarchy=java.net.InetAddress,adapter=com.google.gson.internal.bind.TypeAdapters$22@5906ebcb], Factory[type=java.util.BitSet,adapter=com.google.gson.TypeAdapter$1@258e2e41], com.google.gson.internal.bind.DateTypeAdapter$1@3d299e3, Factory[type=java.util.Calendar+java.util.GregorianCalendar,adapter=com.google.gson.internal.bind.TypeAdapters$25@55a561cf], com.google.gson.internal.sql.SqlTimeTypeAdapter$1@3b938003, com.google.gson.internal.sql.SqlDateTypeAdapter$1@6f3b5d16, com.google.gson.internal.sql.SqlTimestampTypeAdapter$1@78b1cc93, com.google.gson.internal.bind.ArrayTypeAdapter$1@6646153, Factory[type=java.lang.Class,adapter=com.google.gson.TypeAdapter$1@21507a04], com.google.gson.internal.bind.CollectionTypeAdapterFactory@143640d5, com.google.gson.internal.bind.MapTypeAdapterFactory@6295d394, com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory@475e586c, com.google.gson.internal.bind.TypeAdapters$28@657c8ad9, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory@436a4e4b],instanceCreators:{}}";
//
//            assertEquals(expectedResult, gson.toString());
//            //            fileWriter.write(gson.toJson(""));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

//    @Test
//    void addBookToEmptyFile() {
//    }
//
//    @Test
//    void addBookToNonEmptyFile() {
//    }
//
//    @Test
//    void getBookFile() {
//    }
//
//
//    @Test
//    void testAddBookToEmptyFile() {
//    }
//
//    @Test
//    void testAddBookToNonEmptyFile() {
//    }
//
//    @Test
//    void testGetBookFile() {
//    }

//    @TempDir
//    File anotherTempDir;
//    @Test
//    void testWriteBookCsvData() throws IOException {
//        assertTrue(this.anotherTempDir.isDirectory());
//
//    }

//    @Test
//    void writeBookCsvData() {
//
//        try {
//            Path temp = Files.createTempFile("", ".csv");
//
//            String absolutePath = temp.toString();
//            System.out.println("Temp file : " + absolutePath);
//
//            String separator = FileSystems.getDefault().getSeparator();
//            String tempFilePath = absolutePath
//                    .substring(0, absolutePath.lastIndexOf(separator));
//
//            System.out.println("Temp file path : " + tempFilePath);
//
//                    BookFileModel.writeBookCsvData("./src/test/resources/edu.bu.jkrovitz/csvs/books.csv", "Frankenstein", "Mary Shelley", 1994, "Dover Publications", 166, "The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.", "ISBN-13: 978-0-486-28211-4", "ISBN-10: 0-486-28211-4", 1, 1);
//        List<String> expectedLines = Arrays.asList("\"title\",\"author\",\"year\",\"publisher\",\"pages\",\"brief description\"," +
//                "\"isbn-13\",\"isbn-10\",\"copies\",\"quanity available\"", "\"Frankenstein\",\"Mary Shelley\",\"1994\",\"Dover Publications\"," +
//                "\"166\",\"The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.\",\"ISBN-13: 978-0-486-28211-4\",\"ISBN-10: 0-486-28211-4\",\"1\",\"1\"");
//        Assertions.assertAll(
//                ()->assertTrue(Files.exists(Paths.get("./src/test/resources/edu.bu.jkrovitz/csvs/books.csv"))),
//                ()->assertLinesMatch(expectedLines, Files.readAllLines(Paths.get(String.valueOf("./src/test/resources/edu.bu.jkrovitz/csvs/books.csv")))));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        Path path = tempDir.resolve("books.csv");
//        System.out.println(path);
//        BookFileModel.writeBookCsvData("Frankenstein", "Mary Shelley", 1994, "Dover Publications", 166, "The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.", "ISBN-13: 978-0-486-28211-4", "ISBN-10: 0-486-28211-4", 1, 1);
//        List<String> expectedLines = Arrays.asList("\"title\",\"author\",\"year\",\"publisher\",\"pages\",\"brief description\"," +
//                "\"isbn-13\",\"isbn-10\",\"copies\",\"quanity available\"", "\"Frankenstein\", \"Mary Shelley\", \"1994\", \"Dover Publications\"," +
//                " \"166\", \"The story of Victor Frankenstein's terrible creation and the havoc it caused has enthralled generations of readers and inspired countless writers of horror and suspense.\", \"ISBN-13: 978-0-486-28211-4\", \"ISBN-10: 0-486-28211-4\", \"1\", \"1\"");
//        Assertions.assertAll(
//                ()->assertTrue(Files.exists(path)),
//                ()->assertLinesMatch(expectedLines, Files.readAllLines(path)));
//    }
}