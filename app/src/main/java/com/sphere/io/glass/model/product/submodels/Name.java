package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Name{
    @SerializedName("en")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
