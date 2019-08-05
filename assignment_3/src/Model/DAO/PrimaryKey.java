package Model.DAO;

import java.io.Serializable;

public class PrimaryKey<T extends Serializable> implements Serializable {
    T key;

    public PrimaryKey() {
        key = null;
    }

    public PrimaryKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
