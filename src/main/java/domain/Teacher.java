package domain;

public class Teacher extends User {
    public Teacher(int id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 10;
    }
}
