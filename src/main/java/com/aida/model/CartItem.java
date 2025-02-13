package com.aida.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    private Product product;

    private String size;

    private int quantity = 1;

    private Integer mrpPrice;

    private Integer sellingPrice;

    private Long userId;

    // Default constructor
    public CartItem() {
    }

    // All arguments constructor
    public CartItem(Long id, Cart cart, Product product, String size, int quantity, Integer mrpPrice, Integer sellingPrice, Long userId) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.size = size;
        this.quantity = quantity;
        this.mrpPrice = mrpPrice;
        this.sellingPrice = sellingPrice;
        this.userId = userId;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for cart
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // Getter and Setter for product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and Setter for size
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter for mrpPrice
    public Integer getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(Integer mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    // Getter and Setter for sellingPrice
    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity &&
                id.equals(cartItem.id) &&
                cart.equals(cartItem.cart) &&
                product.equals(cartItem.product) &&
                size.equals(cartItem.size) &&
                mrpPrice.equals(cartItem.mrpPrice) &&
                sellingPrice.equals(cartItem.sellingPrice) &&
                userId.equals(cartItem.userId);
    }

    // HashCode method
    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, cart, product, size, quantity, mrpPrice, sellingPrice, userId);
    }

    // ToString method
    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cart=" + cart +
                ", product=" + product +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", mrpPrice=" + mrpPrice +
                ", sellingPrice=" + sellingPrice +
                ", userId=" + userId +
                '}';
    }
}










