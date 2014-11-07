package com.sphere.io.glass.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.google.android.glass.app.Card;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollView;
import com.google.android.glass.widget.Slider;
import com.sphere.io.glass.R;
import com.sphere.io.glass.card.CardAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francisco Villalba on 4/11/14.
 */
public class LoadingActivity extends Activity  {

    private static final int INDETERMINATE = 0;
    private CardScrollView mCardScroller;
    private Slider mSlider;
    private Slider.Indeterminate mIndeterminate;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        // Ensure screen stays on during demo.
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new CardAdapter(createCards(this)));
        setContentView(mCardScroller);
        mSlider = Slider.from(mCardScroller);
        mCardScroller.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        mCardScroller.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    public void onBackPressed() {
        // If the Grace Period is running, cancel it instead of finishing the Activity.
       // displaySlider();
       // super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
        displaySlider();
    }

    private void displaySlider() {
        if (mIndeterminate != null) {
            mIndeterminate.hide();
            mIndeterminate = null;
        } else {
            mIndeterminate = mSlider.startIndeterminate();
        }
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        displaySlider();
        super.onPause();
    }

    private List<CardBuilder> createCards(Context context) {
        ArrayList<CardBuilder> cards = new ArrayList<CardBuilder>();

        cards.add(INDETERMINATE, new CardBuilder(context, CardBuilder.Layout.MENU)
                .setText(getResources().getString(R.string.dialog_loading)));
        return cards;
    }


}
