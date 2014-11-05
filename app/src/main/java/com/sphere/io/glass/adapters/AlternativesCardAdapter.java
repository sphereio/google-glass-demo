/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.sphere.io.glass.adapters;

import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;

import com.sphere.io.glass.R;
import com.sphere.io.glass.model.Alternative;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created with Android Studio .
 * User: Carlos Muñoz Romero
 * Date: 5/11/14
 * Time: 12:29
 * Project: SphereGlass
 */
public class AlternativesCardAdapter extends CardScrollAdapter {

    private List<Alternative> items;

    private Context context;

    public AlternativesCardAdapter(Context context, List<Alternative> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public Alternative getItem(int i) {
        return items.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Alternative alt = items.get(i);
        view = new CardBuilder(context, CardBuilder.Layout.MENU)
          .setText(alt.getName())
          .setIcon(R.drawable.ic_launcher)
          .setFootnote(R.string.tap_to_set)
          .getView();

        addBackgroundImage((RelativeLayout) view, alt);

        return view;
    }

    @Override
    public int getPosition(Object o) {
        return items.indexOf(o);
    }

    private void addBackgroundImage(RelativeLayout view, Alternative alt) {
        if (!TextUtils.isEmpty(alt.getImageUrl())) {
            view.addView(getBgImageView(alt), 0);
            view.addView(getMaskView(), 1);
        }
    }

    private ImageView getBgImageView(Alternative alt) {
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
          RelativeLayout.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setBackgroundColor(Color.CYAN);
        return imageView;
    }

    private View getMaskView() {
        View maskView = new View(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
          RelativeLayout.LayoutParams.MATCH_PARENT);
        maskView.setLayoutParams(params);
        maskView.setBackgroundResource(R.color.alt_mask);
        return maskView;
    }
}
