package domain;

import lombok.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Library {
    private List<Item> items;
    private List<User> users;
    private Stack<Item> returnedItemsStack = new Stack<>();
    private Queue<User> borrowingQueue = new LinkedList<>();
    private Map<String, Item> itemMap = new HashMap<String, Item>();

    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        itemMap.put(item.getId(), item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Allows a user to borrow an item
     * @param user the user borrowing the item
     * @param item the item being borrowed
     */
    public void borrowItem(User user, Item item) {
        try {
            // makes sure can only borrow books
            if (user instanceof Student && !(item instanceof Book)) {
                throw new Exception("Students can only borrow books");
            }

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
     * Returns an item back to the library
     * @param user the user returning the item
     * @param item the item being returned
     */
    public void returnItem(User user, Item item) {
        item.setStatus("In store");
        user.getBorrowedItems().remove(item);

        returnedItemsStack.push(item);
    }

    /**
     * Recursively searches for an item by title
     * @param title the title to search for
     * @param index current recursive index
     * @return matching item or null
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
     * Searches for items by title using streams
     * @param title the title to search for
     * @return list of matching items
     */
    public List<Item> streamSearch(String title) {
        Set<String> titlesSeen = new HashSet<>();

        return items.stream()
                .filter(i -> i.getTitle().equalsIgnoreCase(title))
                .filter(i -> titlesSeen.add(i.getTitle().toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Searches books by author using streams
     * @param author author name
     * @return list of matching books
     */
    public List<Item> searchByAuthor(String author) {
        Set<String> titlesSeen = new HashSet<>();

        return items.stream()
                .filter(i -> i instanceof Book)
                .filter(i -> ((Book) i)
                        .getAuthor()
                        .equalsIgnoreCase(author))
                .filter(i -> titlesSeen.add(i.getTitle().toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Sorts items alphabetically by title.
     */
    public void sortItemsByTitle() {
        items.sort(Comparator.comparing(Item::getTitle));
    }

    /**
     * Sorts users alphabetically by name.
     */
    public void sortUsersByName() {
        users.sort(Comparator.comparing(User::getName));
    }

    /**
     * Loads items from CSV
     * @param path csv path
     */
    public void loadItemsFromCSV(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];

                switch (type.toUpperCase()) {
                    case "BOOK":
                        Book book = new Book(
                                Integer.parseInt(parts[1]),
                                parts[2],
                                parts[3],
                                parts[4],
                                parts[5],
                                parts[6]
                        );
                        addItem(book);
                        break;

                    case "DVD":
                        DVD dvd = new DVD(
                                Integer.parseInt(parts[1]),
                                parts[2],
                                parts[3],
                                parts[4],
                                Integer.parseInt(parts[5])
                        );
                        addItem(dvd);
                        break;

                    case "MAGAZINE":
                        Magazine magazine = new Magazine(
                                Integer.parseInt(parts[1]),
                                parts[2],
                                parts[3],
                                Integer.parseInt(parts[4]),
                                parts[5]
                        );
                        addItem(magazine);
                        break;
                }
            }
            System.out.println("Items loaded successfully");

        } catch (Exception e) {
            System.out.println("Error loading items: " + e.getMessage());
        }
    }

    /**
     * Loads users from a CSV file
     * @param path file path
     */
    public void loadUsersFromCSV(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String type = parts[2];

                switch (type.toLowerCase()) {

                    case "student":
                        users.add(new Student(id, name));
                        break;

                    case "teacher":
                        users.add(new Teacher(id, name));
                        break;

                    case "admin":
                        users.add(new Admin(id, name));
                        break;
                }
            }
            System.out.println("Users loaded successfully");

        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    /**
     * Saves books into a CSV file
     * @param path file path
     */
    public void saveBooksToCSV(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Item item : items) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    bw.write(
                            book.getId() + "," +
                                    book.getTitle() + "," +
                                    book.getStatus() + "," +
                                    book.getIsbn() + "," +
                                    book.getAuthor() + "," +
                                    book.getGenre()
                    );
                    bw.newLine();
                }
            }
            System.out.println("Books saved successfully");

        } catch (Exception e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    /**
     * Saves users into a CSV file
     * @param path file path
     */
    public void saveUsersToCSV(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (User user : users) {
                String type = "";

                if (user instanceof Student) {
                    type = "student";
                } else if (user instanceof Teacher) {
                    type = "teacher";
                } else if (user instanceof Admin) {
                    type = "admin";
                }

                bw.write(
                        user.getId() + "," +
                                user.getName() + "," +
                                type
                );
                bw.newLine();
            }
            System.out.println("Users saved successfully");

        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    /**
     * Prints any type of list using generics
     * @param list the list to print
     * @param <T> generic type
     */
    public <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}
