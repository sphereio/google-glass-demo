package com.sphere.io.glass.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.sphere.io.glass.model.Session;

/**
 * Created by Francisco Villalba on 10/11/14.
 */
public class SpherePreferenceManager {

    private static Context mContext;
    private static Gson mGson;
    private static volatile SpherePreferenceManager preferenceManagerHelper;
    private static String SHARED_KEY_SESSION = "sharedKeySession";

    public static SpherePreferenceManager getInstance(Context context) {
        SpherePreferenceManager result = preferenceManagerHelper;
        if (result == null) {
            synchronized(SpherePreferenceManager.class) {
                result = preferenceManagerHelper;
                if (result == null) {
                    result = new SpherePreferenceManager(context);
                    preferenceManagerHelper = result;
                }
            }
        }
        return result;
    }

    private SpherePreferenceManager(Context context){
        mContext = context;
        mGson = new Gson();
    }

    public static void clear(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        sharedPreferences.edit().clear().commit();
    }

    public static void setSession(Session session){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SHARED_KEY_SESSION,mGson.toJson(session));
        editor.commit();
    }

    public static Session getSession(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String json = sharedPreferences.getString(SHARED_KEY_SESSION, "");
        Session session = mGson.fromJson(json, Session.class);
        return session;
    }
}
