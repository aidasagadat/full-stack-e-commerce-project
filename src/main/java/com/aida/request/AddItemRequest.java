package com.aida.request;

public class AddItemRequest {
    private String size;
    private int quantity;
    private Long productId;

    // Getter for size
    public String getSize() {
        return size;
    }

    // Setter for size
    public void setSize(String size) {
        this.size = size;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter for productId
    public Long getProductId() {
        return productId;
    }

    // Setter for productId
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // toString method
    @Override
    public String toString() {
        return "AddItemRequest{" +
                "size='" + size + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddItemRequest that = (AddItemRequest) o;
        return quantity == that.quantity &&
                size.equals(that.size) &&
                productId.equals(that.productId);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return java.util.Objects.hash(size, quantity, productId);
    }
}
