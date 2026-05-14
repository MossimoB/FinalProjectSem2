import domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testBorrowItem() {
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

        // Actual
        library.borrowItem(student, book);

        // Expected vs Actual
        String expected = "Borrowed";
        String actual = book.getStatus();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnItem() {
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

        library.borrowItem(student, book);

        // Actual
        library.returnItem(student, book);

        // Expected vs Actual
        String expected = "In store";
        String actual = book.getStatus();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRecursiveSearch() {
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

        // Actual
        Item result = library.recursiveSearch("Harry Potter", 0);

        // Expected vs Actual
        String expected = "Harry Potter";
        String actual = result.getTitle();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStreamSearch() {
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

        // Actual
        int actual = library.streamSearch("Harry Potter").size();

        // Expected
        int expected = 1;

        // Assert
        assertEquals(expected, actual);
    }
}
