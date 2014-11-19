package com.sphere.io.glass.model;

import com.sphere.io.glass.utils.Constants;

/**
 * Created by Francisco Villalba on 17/11/14.
 */
public class Address {

    private String country = Constants.COUNTRY_CODE;
    private String state = Constants.COUNTRY_CODE;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    /**
     * id - String - Optional
     title- String - Optional
     salutation - String - Optional
     firstName - String - Optional
     lastName - String - Optional
     streetName - String - Optional
     streetNumber - String - Optional
     additionalStreetInfo - String - Optional
     postalCode - String - Optional
     city - String - Optional
     region - String - Optional
     state - String - Optional
     country - String
     A two-digit country code as per ↗ ISO 3166-1 alpha-2.
     company - String - Optional
     department - String - Optional
     building - String - Optional
     apartment - String - Optional
     pOBox - String - Optional
     phone - String - Optional
     mobile - String - Optional
     email - String - Optional
     additionalAddressInfo - String - Optional
     */
}
