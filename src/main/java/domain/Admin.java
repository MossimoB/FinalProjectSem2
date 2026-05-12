package domain;

public class Admin extends User {
    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }
}
