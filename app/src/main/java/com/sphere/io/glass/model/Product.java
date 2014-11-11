package com.sphere.io.glass.model;

import com.google.gson.annotations.SerializedName;
import com.sphere.io.glass.model.product.submodels.MasterVariant;
import com.sphere.io.glass.model.product.submodels.Name;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Product {

    @SerializedName("id")
    private String productID;

    @SerializedName("name")
    private Name name;

    @SerializedName("masterVariant")
    private MasterVariant masterVariant;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public MasterVariant getMasterVariant() {
        return masterVariant;
    }
}
