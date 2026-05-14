package domain;

import util.Constants;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Student extends User {
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return Constants.MAX_BOOKS_STUDENT;
    }

    @Override
    public boolean canBorrow(Item item) {
        return item instanceof Book;
    }
}
