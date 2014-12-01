/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.sphere.io.glass.model.product.submodels;

import java.io.Serializable;

/**
 * Created by Francisco Villalba on 25/11/14.
 */
public class Value implements Serializable {

    private ConcreteValue value;

    public ConcreteValue getValue() {
        return value;
    }

    public void setValue(ConcreteValue value) {
        this.value = value;
    }
}
