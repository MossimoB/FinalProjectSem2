package domain;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
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

    public abstract boolean canBorrow(Item item);

    public static class IdComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.id.compareTo(o2.id);
        }
    }

    public static class BorrowCountComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o2.borrowedItems.size() - o1.borrowedItems.size();
        }
    }
}
