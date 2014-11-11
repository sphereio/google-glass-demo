package com.sphere.io.glass.api;

import com.sphere.io.glass.model.Session;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Francisco Villalba on 7/11/14.
 */
public interface SphereService {

    @FormUrlEncoded
    @POST("/oauth/token")
    void getSession(@Field("grant_type") String grantType,
                    @Field("scope") String scope,
                    Callback<Session> session) throws RetrofitError;

    @GET("/google-glass-demo/product-projections?where=masterVariant(sku%20%3D%20\"{productSKU}\")")
    void getProductBySKU(@Path("productSKU") String productSKU,
                         Callback<Session> session) throws RetrofitError;

}
