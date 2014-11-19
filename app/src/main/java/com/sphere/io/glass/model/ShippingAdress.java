
package com.sphere.io.glass.model;

import com.sphere.io.glass.utils.Constants;

/**
 * Created by Francisco Villalba on 17/11/14.
 */
public final class ShippingAdress extends Action {

    private Address address = new Address();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
