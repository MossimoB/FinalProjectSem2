import domain.*;
import util.Validation;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

public class MainTest {
    // Borrow Item Tests
    @Test
    @DisplayName("Student borrows a book successfully")
    void testBorrowItem() {
        Library library = new Library();
        Student student = new Student(1, "Alice");
        Book book = new Book(
                1,
                "Harry Potter",
                "In store",
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        library.addUser(student);
        library.addItem(book);

        library.borrowItem(student, book);

        String expected = "Borrowed";
        String actual = book.getStatus();

        Assertions.assertEquals(expected, actual);
    }

    // Return Item Tests
    @Test
    @DisplayName("Student returns a borrowed book successfully")
    void testReturnItem() {
        Library library = new Library();
        Student student = new Student(1, "Alice");
        Book book = new Book(
                1,
                "Harry Potter",
                "In store",
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        library.addUser(student);
        library.addItem(book);

        library.borrowItem(student, book);
        library.returnItem(student, book);

        String expected = "In store";
        String actual = book.getStatus();

        Assertions.assertEquals(expected, actual);
    }

    // Recursive Search Tests
    @Test
    @DisplayName("Recursive search finds book by title")
    void testRecursiveSearch() {
        Library library = new Library();
        Book book = new Book(
                1,
                "Harry Potter",
                "In store",
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        library.addItem(book);

        Item result = library.recursiveSearch("Harry Potter", 0);

        String expected = "Harry Potter";
        String actual = result.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    // Stream Search Tests
    @Test
    @DisplayName("Stream search returns matching books")
    void testStreamSearch() {
        Library library = new Library();
        Book book1 = new Book(
                1,
                "Harry Potter",
                "In store",
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        Book book2 = new Book(
                2,
                "Harry Potter 2",
                "In store",
                "9876543210123",
                "J.K Rowling",
                "Fantasy"
        );

        library.addItem(book1);
        library.addItem(book2);

        List<Item> results = library.streamSearch("Harry Potter");

        int expected = 2;
        int actual = results.size();

        Assertions.assertEquals(expected, actual);
    }

    // Author Search Tests
    @Test
    @DisplayName("Search books by author successfully")
    void testSearchByAuthor() {
        Library library = new Library();
        Book book = new Book(
                1,
                "Clean Code",
                "In store",
                "2222222222222",
                "Robert Martin",
                "Programming"
        );

        library.addItem(book);

        List<Item> results = library.searchByAuthor("Robert Martin");

        int expected = 1;
        int actual = results.size();

        Assertions.assertEquals(expected, actual);
    }

    // Borrow Restriction Tests
    @Test
    @DisplayName("Student cannot borrow a DVD")
    void testStudentCannotBorrowDVD() {
        Library library = new Library();
        Student student = new Student(1, "Alice");
        DVD dvd = new DVD(
                1,
                "Interstellar",
                "In store",
                "Christopher Nolan",
                169
        );

        library.addItem(dvd);
        library.borrowItem(student, dvd);

        String expected = "In store";
        String actual = dvd.getStatus();

        Assertions.assertEquals(expected, actual);
    }

    // Sorting Tests
    @Test
    @DisplayName("Sort items alphabetically by title")
    void testSortItemsByTitle() {
        Library library = new Library();
        Book book1 = new Book(
                1,
                "Zebra Book",
                "In store",
                "1111111111111",
                "Author A",
                "Genre"
        );

        Book book2 = new Book(
                2,
                "Apple Book",
                "In store",
                "2222222222222",
                "Author B",
                "Genre"
        );

        library.addItem(book1);
        library.addItem(book2);

        library.sortItemsByTitle();

        String expected = "Apple Book";
        String actual = library.getItems().get(0).getTitle();

        Assertions.assertEquals(expected, actual);
    }

    // Validation Tests
    @Test
    @DisplayName("Valid ISBN returns true")
    void testISBNValidation() {
        boolean expected = true;
        boolean actual = Validation.isValidISBN("1234567890123");

        Assertions.assertEquals(expected, actual);
    }
}
