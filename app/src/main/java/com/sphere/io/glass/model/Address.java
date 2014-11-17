package com.sphere.io.glass.model;

/**
 * Created by Francisco Villalba on 17/11/14.
 */
public class Address {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

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
