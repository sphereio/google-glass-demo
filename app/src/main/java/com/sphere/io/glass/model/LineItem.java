
package com.sphere.io.glass.model;

/**
 * Created by Francisco Villalba on 17/11/14.
 */
public final class LineItem extends Action {

    private String productId;

    private int variantId;

    private int quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
