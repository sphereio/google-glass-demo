package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Name implements Serializable {
    @SerializedName("en")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
