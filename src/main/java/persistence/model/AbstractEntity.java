package persistence.model;

/**
 * Created by dan on 26.2.15.
 */
public abstract class AbstractEntity {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}