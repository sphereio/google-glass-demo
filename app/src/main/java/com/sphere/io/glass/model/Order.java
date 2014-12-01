package com.sphere.io.glass.model;

/**
 * Created by Francisco Villalba on 19/11/14.
 */
public class Order {

    private String id;
    private int version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
