package com.sphere.io.glass.model;

import com.sphere.io.glass.utils.Constants;

/**
 * Created by Francisco Villalba on 19/11/14.
 */
public class Payment extends Action {

    private String paymentState = Constants.VALUE_ORDER_PAID;


    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }
}
