package domain;

public class Student extends User {
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}
