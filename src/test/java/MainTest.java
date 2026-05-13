import domain.Book;
import domain.Library;
import domain.Student;

import org.junit.jupiter.api.*;

public class MainTest {

    @Test
    public void testBorrowBook() throws Exception {

        Library library = new Library();

        Student student = new Student(1, "Alice");

        Book book = new Book(
                1,
                "Harry Potter",
                "in store",
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        library.borrowItem(student, book);

        Assertions.assertEquals("borrowed", book.getStatus());
    }
}