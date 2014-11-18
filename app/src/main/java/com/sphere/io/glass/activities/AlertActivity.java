package com.sphere.io.glass.activities;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.glass.widget.CardBuilder;
import com.sphere.io.glass.R;

/**
 * Created by Francisco Villalba on 18/11/14.
 */
public class AlertActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildView();
    }

    private void buildView() {
              setContentView(new CardBuilder(this, CardBuilder.Layout.ALERT)
                     // .setIcon(iconResId)
                      .setText(R.string.alert_text)
                              //.setFootnote(footnoteResId)
                      .getView());
    }
}
