package domain;

import lombok.*;

@Getter
@Setter
public abstract class Item {
    protected int id;
    protected String title;
    protected String status;

    private static int nextId = 1;

    public Item(int id, String title, String status) {
        // getting error saying that nextId should be string
        // or wrap this.id in parseInt
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.status = status;
    }
}
