package com.sphere.io.glass.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollView;
import com.google.android.glass.widget.Slider;
import com.sphere.io.glass.R;
import com.sphere.io.glass.api.SphereApiCaller;
import com.sphere.io.glass.card.CardAdapter;
import com.sphere.io.glass.model.Action;
import com.sphere.io.glass.model.ActionsWrapper;
import com.sphere.io.glass.model.LineItem;
import com.sphere.io.glass.model.Cart;
import com.sphere.io.glass.model.Order;
import com.sphere.io.glass.model.Product;
import com.sphere.io.glass.model.ShippingAdress;
import com.sphere.io.glass.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Francisco Villalba on 4/11/14.
 */
public class ConfirmationActivity extends BaseActivity  {

    private static final int INDETERMINATE = 0;
    private CardScrollView mCardScroller;
    private Slider mSlider;
    private Slider.Indeterminate mIndeterminate;
    private boolean cartCreated;
    private boolean orderPurchased;
    private Product mProduct;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // Ensure screen stays on during demo.
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
        displaySlider();
        SphereApiCaller.getInstance(this).createCart();
    }

    public void onEvent(Cart cart){
        if (!cartCreated){
            cartCreated = true;
            addItemToCart(cart);
        }else{
            convertCartToOrder(cart);
        }
    }

    public void onEvent (Order order){
        if(!orderPurchased) {
            payOrder(order);
        }else{
            //TODO

        }
    }

    private void addItemToCart(Cart cart){
        ActionsWrapper updateAction = new ActionsWrapper();
        updateAction.setVersion(cart.getVersion());
        final LineItem addProduct = new LineItem();
        addProduct.setQuantity(1);
        addProduct.setVariantId(1);
        addProduct.setProductId(mProduct.getProductID());
        addProduct.setAction(Constants.ACTION_ADD_LINE_ITEM);
        final ShippingAdress addShipingAdress = new ShippingAdress();
        addShipingAdress.setAction(Constants.ACTION_SET_SHIPPING_ADDRESS);

        updateAction.setActions(new ArrayList<Action>() {{
            add(addProduct);
            add(addShipingAdress);
        }});
        SphereApiCaller.getInstance(this).addItemToCart(cart.getId(),updateAction);
    }

    private void convertCartToOrder(Cart cart){
        SphereApiCaller.getInstance(this).createOrderFromCart(cart.getId(),cart.getVersion());
    }

    private void payOrder(Order order){
        //SphereApiCaller.getInstance(this).updateOrder(order.g);
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
                .setText(getResources().getString(R.string.progress_confirm)));
        return cards;
    }
}
