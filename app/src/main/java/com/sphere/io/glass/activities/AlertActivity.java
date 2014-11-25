package com.sphere.io.glass.activities;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.glass.widget.CardBuilder;
import com.sphere.io.glass.R;
import com.sphere.io.glass.utils.Constants;

/**
 * Created by Francisco Villalba on 18/11/14.
 */
public class AlertActivity extends Activity {

    private boolean isProductError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recoverData();
        buildView();
    }

    private void recoverData(){
        Bundle extras = getIntent().getExtras();
        if (extras!= null) {
            isProductError = extras.getBoolean(Constants.ERROR_PRODUCT, false);
        }
    }

    private void buildView() {
        int textResource = R.string.alert_text_connection;
        if (isProductError){
            textResource = R.string.alert_text_product;
        }
              setContentView(new CardBuilder(this, CardBuilder.Layout.ALERT)
                     .setIcon(getResources().getDrawable(R.drawable.alert))
                      .setText(textResource)
                               .setFootnote(R.string.alert_text_footnote)
                      .getView());
    }
}
