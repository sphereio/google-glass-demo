package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Value implements Serializable {

    @SerializedName("currencyCode")
    private String code;

    @SerializedName("centAmount")
    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


}
