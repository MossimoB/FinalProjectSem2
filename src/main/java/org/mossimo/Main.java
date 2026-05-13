package org.mossimo;

import domain.*;

public class Main {
    static void main(String[] args) {
        Library library = new Library();
        Student student = new Student(1, "Alice");

        Book book = new Book(
                1,
                "Harry Potter1",
                "in store",
                "1234567890123",
                "J.K. Rowling",
                "Fantasy"
        );

        library.addUser(student);

        library.addItem(book);

        library.borrowItem(student, book);
    }
}
