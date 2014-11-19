
package com.sphere.io.glass.model;

import com.sphere.io.glass.utils.Constants;

/**
 * Created by Francisco Villalba on 17/11/14.
 */
public final class ShippingAdress extends Action {

    private String firstName;
    private String countryCode= Constants.COUNTRY_CODE;
    private String stateCode= Constants.COUNTRY_CODE;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
