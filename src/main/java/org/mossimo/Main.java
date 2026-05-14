package org.mossimo;

import domain.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.loadItemsFromCSV("src/main/resources/books.csv");
        library.loadUsersFromCSV("src/main/resources/users.csv");

        library.sortItemsByTitle();
        library.sortUsersByName();

        Student student = new Student(1, "Alice");

        Book book = new Book(
                10,
                "Java Programming",
                "In store",
                "9999999999999",
                "John Smith",
                "Education"
        );

        library.borrowItem(student, book);
        library.returnItem(student, book);

        Admin admin = new Admin(99, "Admin");

        admin.setLibrary(library);
        admin.generateReport();

        System.out.println("\nSearch by title:");
        System.out.println(library.streamSearch("Harry Potter"));

        System.out.println("\nSearch by author:");
        System.out.println(library.searchByAuthor("J.K. Rowling"));

        library.saveBooksToCSV("src/main/resources/books_backup.csv");
        library.saveUsersToCSV("src/main/resources/users_backup.csv");
    }
}
