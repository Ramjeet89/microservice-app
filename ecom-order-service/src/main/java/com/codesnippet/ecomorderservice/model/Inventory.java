package com.codesnippet.ecomorderservice.model;

import java.util.Objects;

public class Inventory {
    private Long productId;
    private int quantity;

    public Inventory() {

    }

    public Inventory(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return quantity == inventory.quantity && Objects.equals(productId, inventory.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}

