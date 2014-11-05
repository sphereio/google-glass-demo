package com.sphere.io.glass;

import com.google.android.glass.widget.CardScrollView;

import com.sphere.io.glass.adapters.AlternativesCardAdapter;
import com.sphere.io.glass.mock.AlternativesMocks;

import android.app.Activity;
import android.os.Bundle;

public class AlternativesActivity extends Activity {

    private CardScrollView mCardScroller;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new AlternativesCardAdapter(this, new AlternativesMocks().getAlternativesMocks()));
        setContentView(mCardScroller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }
}
