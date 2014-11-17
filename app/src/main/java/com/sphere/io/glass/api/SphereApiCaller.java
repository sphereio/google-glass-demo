package com.sphere.io.glass.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sphere.io.glass.R;
import com.sphere.io.glass.model.Cart;
import com.sphere.io.glass.model.ProductResponseWrapper;
import com.sphere.io.glass.model.Session;
import com.sphere.io.glass.model.UpdateAction;
import com.sphere.io.glass.utils.SpherePreferenceManager;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Francisco Villalba on 7/11/14.
 */
public class SphereApiCaller {

    private  static RestAdapter mRestAdapter;
    private static SphereApiCaller mSphereApiCaller;
    //KNOWLEDGE PURPOSES
    private static final String CLIENT_ID = "654GYqPJccG9X3KCrKImwLyO";
    private static final String CLIENT_SECRET = "bAS3tW-PfDpNbxlqSIiUJ7H-XDOo6BIN";
    private static final String KEY_AUTHORIZATION = "Authorization";
    private static final String AUTHORIZATION = "Basic NjU0R1lxUEpjY0c5WDNLQ3JLSW13THlPOmJBUzN0Vy1QZkRwTmJ4bHFTSWlVSjdILVhET282QklO";
    private static final String AUTHORIZATION_BEARER = "Bearer ";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String SCOPE = "manage_project:google-glass-demo";
    private static final String PERMISSIONS = "manage_project:google-glass-demo";
    private static final String CURRENCY = "EUR";

    /**
     * Empty constructor.
     */
    private SphereApiCaller(final Context context) {
        Gson gson = new GsonBuilder()
                .create();
        mRestAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)

                .setEndpoint(context.getString(R.string.sphere_endpoint))

                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        Session authSession = SpherePreferenceManager.getInstance(context).getSession();
                        if (authSession == null) {
                            request.addHeader(KEY_AUTHORIZATION, AUTHORIZATION);
                        } else {
                            //Technically never reached, must be checked
                            generateRestAdapter(context);
                        }
                    }
                })
                .setConverter(new GsonConverter(gson))
                .build();
    }

    private static void generateRestAdapter(final Context context){
        mRestAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(context.getString(R.string.sphere_api_endpoint))

                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        Session authSession = SpherePreferenceManager.getInstance(context).getSession();
                            request.addHeader(KEY_AUTHORIZATION, new StringBuffer(AUTHORIZATION_BEARER)
                                    .append(authSession.getToken()).toString());

                    }
                })
                .build();
    }

    public static SphereApiCaller getInstance(Context context) {
        if (mSphereApiCaller == null) {
            mSphereApiCaller = new SphereApiCaller(context);
        }
        Session authSession = SpherePreferenceManager.getInstance(context).getSession();
        if (authSession != null) {
            mSphereApiCaller = new SphereApiCaller(context);
            generateRestAdapter(context);
        }
        return mSphereApiCaller;
    }

    public void getSession() {
        SphereService service = mRestAdapter.create(SphereService.class);
        service.getSession(GRANT_TYPE,SCOPE,new GenericApiCallback<Session>());
    }

    public void getProductBySKU(String productSKU){
        SphereService service = mRestAdapter.create(SphereService.class);
        String key = new StringBuffer("masterVariant(sku=\"").append(productSKU).append("\")").toString();
        service.getProductBySKU(key, new GenericApiCallback<ProductResponseWrapper>());
    }

    public void createCart(){
        SphereService service = mRestAdapter.create(SphereService.class);
        service.createCart(CURRENCY, new GenericApiCallback<Cart>());
    }

    public void addItemToCart(String cartId, UpdateAction updateAction){
        SphereService service = mRestAdapter.create(SphereService.class);
        service.addItemToCart(cartId, updateAction, new GenericApiCallback<Cart>());
    }

    public void createOrderFromCart(){
        SphereService service = mRestAdapter.create(SphereService.class);

    }




}