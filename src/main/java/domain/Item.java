package domain;

import lombok.*;

@Getter
@Setter
public abstract class Item {
    protected int id;
    protected String title;
    protected String status;

    public Item(int id, String title, String status) {
        this.id = String.format("%04d, ");
        this.title = title;
        this.status = status;
    }
}
