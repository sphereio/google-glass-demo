package com.sphere.io.glass.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class ProductResponseWrapper {

    @SerializedName("results")
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
