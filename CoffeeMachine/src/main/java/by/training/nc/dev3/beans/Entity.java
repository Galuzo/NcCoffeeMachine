package by.training.nc.dev3.beans;

import java.io.Serializable;

/**
 * Created by Win on 10.04.2017.
 */
public class Entity implements Serializable {
    private int id;

    public Entity()
    {}
    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
