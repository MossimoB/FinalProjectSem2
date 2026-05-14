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



        library.loadBooksFromCSV("src/main/resources/books.csv");
        library.loadUsersFromCSV("src/main/resources/users.csv");

        library.sortItemsByTitle();
        library.sortUsersByName();

        System.out.println("Books found by title:");
        System.out.println(library.streamSearch("Harry Potter"));
        System.out.println("Books found by author:");
        System.out.println(library.searchByAuthor("J.K. Rowling"));

        // backup csv files
        library.saveBooksToCSV("src/main/resources/books_backup.csv");
        library.saveUsersToCSV("src/main/resources/users_backup.csv");
    }
}
