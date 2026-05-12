package domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class User {
    protected int id;
    protected String name;
    protected List<Item> borrowedItems;

    public User(int id, String name, List<Item> borrowedItems) {
        this.id = id;
        this.name = name;
        borrowedItems = new ArrayList<>();
    }

    public abstract int getBorrowLimits();
}
