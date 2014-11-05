package com.sphere.io.glass.model;

/**
 * Created with Android Studio .
 * User: Carlos Muñoz Romero
 * Date: 5/11/14
 * Time: 12:28
 * Project: SphereGlass
 */
public class Alternative {

    private int id;

    private String name;

    private String imageUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
