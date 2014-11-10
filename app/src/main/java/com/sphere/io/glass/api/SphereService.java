package com.sphere.io.glass.api;

import com.sphere.io.glass.model.Session;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by Francisco Villalba on 7/11/14.
 */
public interface SphereService {

    @FormUrlEncoded
    @POST("/oauth/token")
    void getSession(@Header("Authorization") String authorization,
                    @Field("grant_type") String grantType,
                    @Field("scope") String scope,
                    Callback<Session> session) throws RetrofitError;

}
