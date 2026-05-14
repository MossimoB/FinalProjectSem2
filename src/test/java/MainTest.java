import domain.*;
import org.junit.jupiter.api.Test;
import java.util.List;
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
                "Harry Potter",
                "In store",
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        library.addItem(book1);
        library.addItem(book2);

        // Actual
        List<Item> results = library.streamSearch("Harry Potter");

        // Expected vs Actual
        int expected = 1;
        int actual = results.size();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByAuthor() {
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

        // Actual
        List<Item> results = library.searchByAuthor("Robert Martin");

        // Expected vs Actual
        int expected = 1;
        int actual = results.size();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStudentCannotBorrowDVD() {
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

        // Actual
        library.borrowItem(student, dvd);

        // Expected vs Actual
        String expected = "In store";
        String actual = dvd.getStatus();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSortItemsByTitle() {
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

        // Actua
        library.sortItemsByTitle();

        // Expected vs Actual
        String expected = "Apple Book";
        String actual = library.getItems().get(0).getTitle();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testISBNValidation() {
        // Expected vs Actual
        boolean expected = true;
        boolean actual = util.Validation.isValidISBN("1234567890123");

        // Assert
        assertEquals(expected, actual);
    }
}
