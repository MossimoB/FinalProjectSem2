package domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    private static int nextId = 1;

    public User(int id, String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;

        borrowedItems = new ArrayList<>();
    }

    public abstract int getBorrowLimit();
}
