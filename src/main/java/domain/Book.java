package domain;

import lombok.*;

@Getter
@Setter
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(int id, String title, String status, String isbn, String author, String genre) {
        super(id, title, status);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }
}
