package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Image {

    @SerializedName("url")
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
