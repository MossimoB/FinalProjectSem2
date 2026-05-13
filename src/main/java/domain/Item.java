package domain;

import lombok.*;

@Getter
@Setter
public abstract class Item {
    protected String id;
    protected String title;
    protected String status;

    private static int nextId = 1;

    public Item(int id, String title, String status) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.status = status;
    }
}
