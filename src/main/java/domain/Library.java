package domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Library {
    private List<Item> items;
    private List<User> users;

    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void borrowItem(User user, Item item) {
        try {
            if (item.getStatus().equalsIgnoreCase("Borrowed")) {
                throw new Exception("Item already borrowed");
            }

            if (user.getBorrowedItems().size() >= user.getBorrowLimit()) {
                throw new Exception("Borrow limit reached");
            }

            item.setStatus("Borrowed");
            user.getBorrowedItems().add(item);
            System.out.println("Item borrowed successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void returnItem(User user, Item item) {
        item.setStatus("In store");
        user.getBorrowedItems().remove(item);
    }

    public Item recursiveSearch(String title, int index) {
        if (index >= items.size()) {
            return null;
        }

        Item item = items.get(index);

        if (item.getTitle().equalsIgnoreCase(title)) {
            return item;
        }

        return recursiveSearch(title, index + 1);
    }

    public List<Item> streamSearch(String title) {
        return items.stream()
                .filter(i -> i.getTitle()
                .equalsIgnoreCase(title))
                .toList();
    }
}
