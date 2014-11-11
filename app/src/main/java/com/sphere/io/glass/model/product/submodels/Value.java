package com.sphere.io.glass.model.product.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Francisco Villalba on 11/11/14.
 */
public class Value {

    @SerializedName("currencyCode")
    private String code;

    @SerializedName("centAmount")
    private float amount;
}
