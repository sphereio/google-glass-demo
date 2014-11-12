package com.sphere.io.glass.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;
import com.sphere.io.glass.api.SphereApiCaller;
import com.sphere.io.glass.model.ProductResponseWrapper;
import com.sphere.io.glass.utils.Constants;

import de.greenrobot.event.EventBus;

/**
 * Created by Francisco Villalba on 6/11/14.
 */
public class ProductActivity extends Activity {

    private GestureDetector mGestureDetector;
    private final static String TAG = ProductActivity.class.getName();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.e(TAG,"CREATED");
        EventBus.getDefault().register(this);
        buildView();
        createGestureDetector();
    }
    private void buildView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //setContentView(populateCard(recoverData()).getView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"RESUMED");
        SphereApiCaller.getInstance(this).getProductBySKU(recoverData());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(ProductResponseWrapper productResponseWrapper){
        Log.e(TAG, productResponseWrapper.getProducts().get(0).getProductID());
        setContentView(populateCard(productResponseWrapper.getProducts().get(0).getProductID()).getView());
        Log.e(TAG, productResponseWrapper.getProducts().get(0).getProductID());
    }

    private CardBuilder populateCard(String text) {
         return new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText(text);
    }

    private String recoverData(){
        Bundle extras = getIntent().getExtras();
        String text ="";
        if (extras != null) {
             text = extras.getString(Constants.KEY_SKU);
        }
        return text;
    }

    private void createGestureDetector() {
        mGestureDetector = new GestureDetector(this);
        mGestureDetector.setBaseListener(new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TWO_TAP) {
                    displayConfirmationCard();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (mGestureDetector != null) {
            return mGestureDetector.onMotionEvent(event);
        }
        return false;
    }

    private void displayConfirmationCard(){
        //TODO displays a card confirming the purchase
    }
}
