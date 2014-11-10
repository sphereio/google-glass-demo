package com.sphere.io.glass.utils;

import android.content.Context;

/**
 * Created by Francisco Villalba on 10/11/14.
 */
public class PreferenceManager {

    private Context mContext;
    private volatile PreferenceManager preferenceManagerHelper;

    public PreferenceManager getPreferenceManagerHelper(Context context) {
        PreferenceManager result = preferenceManagerHelper;
        if (result == null) {
            synchronized(this) {
                result = preferenceManagerHelper;
                if (result == null) {
                    result = new PreferenceManager(context);
                    preferenceManagerHelper = result;
                }
            }
        }
        return result;
    }

    private PreferenceManager(Context context){
        mContext = context;
    }

}
