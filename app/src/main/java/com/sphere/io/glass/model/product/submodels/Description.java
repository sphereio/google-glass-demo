package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Francisco Villalba on 13/11/14.
 */
public class Description {


    @SerializedName("en")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
