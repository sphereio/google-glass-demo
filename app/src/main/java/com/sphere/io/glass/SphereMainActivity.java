package com.sphere.io.glass;

import com.github.barcodeeye.scan.CaptureActivity;
import com.github.barcodeeye.scan.api.CardPresenter;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.google.android.glass.widget.Slider;
import com.sphere.io.glass.activities.LoadingActivity;
import com.sphere.io.glass.activities.ProductActivity;
import com.sphere.io.glass.api.SphereApiCaller;
import com.sphere.io.glass.card.CardAdapter;
import com.sphere.io.glass.model.Session;
import com.sphere.io.glass.utils.Constants;
import com.sphere.io.glass.utils.SpherePreferenceManager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class SphereMainActivity extends Activity {
    private static final int NAVIGATION_QRCODE = 0;
    private CardScrollView mCardScroller;
    private Slider.Indeterminate mSlider;
    private static String TAG = SphereMainActivity.class.getName();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        buildView();
    }

    private void buildView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new CardAdapter(createCards()));
        setContentView(mCardScroller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        mCardScroller.activate();
        mSlider = Slider.from(mCardScroller).startIndeterminate();
        SphereApiCaller.getInstance(this).getSession();

    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(Session session){
        SpherePreferenceManager.getInstance(this).setSession(session);
        Log.e(TAG, "SESSION WITH TOKEN " + session.getToken() + " STORED");
        mSlider.hide();
        startActivity(CaptureActivity.newIntent(SphereMainActivity.this));
        finish();
    }

    private List<CardBuilder> createCards() {
        ArrayList<CardBuilder> cards = new ArrayList<CardBuilder>();
        cards.add(NAVIGATION_QRCODE, new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText(R.string.app_title).setIcon(R.drawable.icon_logo));
        return cards;
    }
}
