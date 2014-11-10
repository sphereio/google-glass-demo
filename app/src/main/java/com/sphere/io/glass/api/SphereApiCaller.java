package com.sphere.io.glass.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sphere.io.glass.R;
import com.sphere.io.glass.model.Session;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Francisco Villalba on 7/11/14.
 */
public class SphereApiCaller {

    private RestAdapter mRestAdapter;
    private static  SphereApiCaller mSphereApiCaller;
    private static final String CLIENT_ID = "654GYqPJccG9X3KCrKImwLyO";
    private static final String CLIENT_SECRET = "bAS3tW-PfDpNbxlqSIiUJ7H-XDOo6BIN";
    private static final String KEY_AUTHORIZATION = "Authorization";
    private static final String AUTHORIZATION = "Basic NjU0R1lxUEpjY0c5WDNLQ3JLSW13THlPOmJBUzN0Vy1QZkRwTmJ4bHFTSWlVSjdILVhET282QklO";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String SCOPE = "manage_project:google-glass-demo";
    private static final String PERMISSIONS = "manage_project:google-glass-demo";



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
                        request.addHeader(KEY_AUTHORIZATION, AUTHORIZATION);
                        /*if (prefs.contains(Constants.PREFS_USERNAME)
                                && prefs.contains(Constants.PREFS_AUTH_TOKEN)) {
                            request.addHeader(Constants.HEADER_AUTH_USERNAME,
                                    prefs.getString(Constants.PREFS_USERNAME, null));

                            request.addHeader(Constants.HEADER_DEVICE_TYPE, "android");
                        }*/
                    }
                })
                .setConverter(new GsonConverter(gson))
                .build();
    }

    public static SphereApiCaller getInstance(Context context) {
        if (mSphereApiCaller == null) {
            mSphereApiCaller = new SphereApiCaller(context);
        }
        return mSphereApiCaller;
    }

    public void getSession() {
        SphereService service = mRestAdapter.create(SphereService.class);
        service.getSession(AUTHORIZATION,GRANT_TYPE,SCOPE,new GenericApiCallback<Session>());
    }


}