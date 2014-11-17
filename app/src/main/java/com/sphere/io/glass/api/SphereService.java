package com.sphere.io.glass.api;

import com.sphere.io.glass.model.Cart;
import com.sphere.io.glass.model.Product;
import com.sphere.io.glass.model.ProductResponseWrapper;
import com.sphere.io.glass.model.Session;
import com.sphere.io.glass.model.UpdateAction;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Francisco Villalba on 7/11/14.
 */
public interface SphereService {

    @FormUrlEncoded
    @POST("/oauth/token")
    void getSession(@Field("grant_type") String grantType,
                    @Field("scope") String scope,
                    Callback<Session> session) throws RetrofitError;

    @GET("/google-glass-demo/product-projections")
    void getProductBySKU(@Query(value = "where", encodeName = true) String productSKU,
                         Callback<ProductResponseWrapper> productResponseWrapper) throws RetrofitError;


    @POST("/google-glass-demo/carts")
    void createCart(@Field("currency") String currency, Callback<Cart> cart) throws RetrofitError;

    @POST("/google-glass-demo/carts/{cartId}")
    void addItemToCart(@Path("cartId") String cartId, @Body UpdateAction updateAction, Callback<Cart> cart) throws RetrofitError;

    @POST("/google-glass-demo/orders")
    void createOrderFromCart(@Field("id") String cartId,@Field("version") int version,@Field ("paymentState") String paymentState);

}
