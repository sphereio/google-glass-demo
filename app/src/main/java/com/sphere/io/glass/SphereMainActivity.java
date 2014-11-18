package com.sphere.io.glass;

import com.github.barcodeeye.scan.CaptureActivity;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollView;
import com.google.android.glass.widget.Slider;
import com.sphere.io.glass.activities.BaseActivity;
import com.sphere.io.glass.api.SphereApiCaller;
import com.sphere.io.glass.card.CardAdapter;
import com.sphere.io.glass.model.Session;
import com.sphere.io.glass.utils.SpherePreferenceManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class SphereMainActivity extends BaseActivity {
    private static final int NAVIGATION_QRCODE = 0;
    private CardScrollView mCardScroller;
    private Slider.Indeterminate mSlider;
    private static String TAG = SphereMainActivity.class.getName();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //Clear the stored data before leaving the app,
        // TODO should check if it fits the app workflow
        SpherePreferenceManager.getInstance(this).clear();
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
        mCardScroller.activate();
        mSlider = Slider.from(mCardScroller).startIndeterminate();
        SphereApiCaller.getInstance(this).getSession();

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
