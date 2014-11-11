package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class MasterVariant {

    @SerializedName("images")
    private ArrayList<Image> images;

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
