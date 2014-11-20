package com.sphere.io.glass.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;

/**
 * Created by Francisco Villalba on 14/11/14.
 */
public class BaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(RetrofitError retrofitError) {
        startActivity(new Intent(this, AlertActivity.class));
    }

}
