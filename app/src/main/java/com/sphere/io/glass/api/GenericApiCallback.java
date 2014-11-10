
package com.sphere.io.glass.api;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GenericApiCallback<T> implements Callback<T> {
    @Override
    public void success(T t, Response response) {
        if(t != null) {
            EventBus.getDefault().post(t);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        /*Utils.triggerError(error);*/
    }

}
