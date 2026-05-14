package domain;

import interfaces.Reportable;
import lombok.*;
import java.util.List;

@Getter
@Setter
public class Admin extends User implements Reportable {
    private Library library;

    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }

    @Override
    public void generateReport() {
        if (library == null) {
            System.out.println("No library assigned");
            return;
        }

        List<Item> items = library.getItems();

        System.out.println("===== LIBRARY REPORT =====");
        System.out.println("\nBorrowed Items:");

        for (Item item : items) {
            if (item.getStatus().equalsIgnoreCase("Borrowed")) {
                System.out.println(item.getTitle());
            }
        }
        System.out.println("\nIn Store Items:");

        for (Item item : items) {
            if (item.getStatus().equalsIgnoreCase("In store")) {
                System.out.println(item.getTitle());
            }
        }

        System.out.println("\nLost Items:");
        for (Item item : items) {
            if (item.getStatus().equalsIgnoreCase("Lost")) {
                System.out.println(item.getTitle());
            }
        }
    }
}
