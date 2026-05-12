package domain;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items;
    private List<User> users;

    public Library(List<Item> items, List<Item> users) {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addUser(User user) {
        users.add(user);
    }
}
