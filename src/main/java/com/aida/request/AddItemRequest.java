package com.aida.request;

import java.util.Objects;

public class AddItemRequest {
    private String size;
    private int quantity;

    // Constructor
    public AddItemRequest() {}

    public AddItemRequest(String size, int quantity) {
        this.size = size;
        this.quantity = quantity;
    }

    // Getters
    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString()
    @Override
    public String toString() {
        return "AddItemRequest{size='" + size + "', quantity=" + quantity + "}";
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddItemRequest that = (AddItemRequest) o;
        return quantity == that.quantity && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, quantity);
    }
}
