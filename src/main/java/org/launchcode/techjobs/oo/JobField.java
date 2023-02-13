package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    //TODO: Code Common Fields
    private int id;
    private static int nextId = 1;
    private String value;
    //TODO: Code Common Constructors
    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //TODO: Code Common Getters and Setters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    //TODO: Code Common Custom Methods
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
