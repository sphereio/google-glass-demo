
package com.sphere.io.glass.api;

import android.util.Log;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GenericApiCallback<T> implements Callback<T> {

    private static final String TAG = GenericApiCallback.class.getName();
    @Override
    public void success(T t, Response response) {
        Log.e(TAG, "SUCCESS");
        if(t != null) {
            EventBus.getDefault().post(t);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(TAG, "FAILURE "+error.toString() );

        /*Utils.triggerError(error);*/
    }

}
