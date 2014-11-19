package com.sphere.io.glass.model;

import com.sphere.io.glass.utils.Constants;

import java.util.zip.CheckedOutputStream;

/**
 * Created by Francisco Villalba on 19/11/14.
 */
public class Currency {

    private String currency = Constants.KEY_CURRENCY;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
