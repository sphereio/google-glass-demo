package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class MasterVariant implements Serializable {

    private ArrayList<Image> images;

    private ArrayList<Value> prices;

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Value> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Value> prices) {
        this.prices = prices;
    }


}
