package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Image {

    @SerializedName("url")
    private int imageURL;

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }
}
