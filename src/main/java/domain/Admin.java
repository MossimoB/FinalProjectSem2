package domain;

import interfaces.Reportable;

public class Admin extends User implements Reportable {

    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 0;
    }

    @Override
    public void generateReport() {
        System.out.println("LIBRARY REPORT");
        System.out.println("Admin report generated successfully.");
    }
}
