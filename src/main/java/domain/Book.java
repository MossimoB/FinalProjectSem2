package domain;

import lombok.*;
import util.Validation;

@Getter
@Setter
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(int id,
                String title,
                String status,
                String isbn,
                String author,
                String genre) {

        super(id, title, status);

        if (!Validation.isValidISBN(isbn)) {
            throw new IllegalArgumentException("Invalid ISBN");
        }

        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }
}
