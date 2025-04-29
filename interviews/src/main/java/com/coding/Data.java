package com.coding;

public class Data {

    private String id;

    public Data(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Data [id=" + id + "]";
    }
}
