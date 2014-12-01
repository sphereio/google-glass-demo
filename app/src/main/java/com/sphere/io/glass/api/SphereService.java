package com.sphere.io.glass.api;

import com.sphere.io.glass.model.ActionsWrapper;
import com.sphere.io.glass.model.Cart;
import com.sphere.io.glass.model.Currency;
import com.sphere.io.glass.model.Order;
import com.sphere.io.glass.model.ProductResponseWrapper;
import com.sphere.io.glass.model.Session;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
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
    void createCart(@Body Currency currency, Callback<Cart> cart) throws RetrofitError;

    @POST("/google-glass-demo/carts/{cartId}")
    void addItemToCart(@Path("cartId") String cartId, @Body ActionsWrapper actionsWrapper, Callback<Cart> cart) throws RetrofitError;

    @POST("/google-glass-demo/orders")
    void createOrderFromCart(@Body Cart cart, Callback<Order> order)throws RetrofitError;

    @POST("/google-glass-demo/orders/{orderId}")
    void updateOrder(@Path("orderId") String orderId, @Body ActionsWrapper actionsWrapper, Callback<Order> order)throws RetrofitError;

}
