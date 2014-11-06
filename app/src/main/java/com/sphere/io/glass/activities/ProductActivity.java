/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.sphere.io.glass.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;
import com.sphere.io.glass.utils.Constants;

/**
 * Created by Francisco Villalba on 6/11/14.
 */
public class ProductActivity extends Activity {

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        buildView();
        createGestureDetector();
    }
    private void buildView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(populateCard(recoverData()).getView());
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
        //TODO displays a livecard confirming the purchase
    }
}
