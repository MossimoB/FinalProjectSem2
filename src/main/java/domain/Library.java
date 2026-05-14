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

    /**
     * Allows a user to borrow an item from the library.
     * Checks whether the item is already borrowed and whether the user has reached their borrowing limit.
     * @param user the user borrowing the item
     * @param item the item to be borrowed
     */
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

    /**
     * Returns an item back to the library and removes it from the user's borrowed items list.
     * @param user the user returning the item
     * @param item the item being returned
     */
    public void returnItem(User user, Item item) {
        item.setStatus("In store");
        user.getBorrowedItems().remove(item);
    }

    /**
     * Recursively searches for an item by title.
     * @param title the title of the item to search for
     * @param index the current index used during recursion
     * @return the matching item if found, otherwise null
     */
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

    /**
     * Searches for items by title using Java Streams.
     * @param title the title of the item to search for
     * @return a list of matching items
     */
    public List<Item> streamSearch(String title) {
        return items.stream()
                .filter(i -> i.getTitle()
                .equalsIgnoreCase(title))
                .toList();
    }
}
