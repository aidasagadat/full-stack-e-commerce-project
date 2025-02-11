package com.aida.service;

import com.aida.model.Cart;
import com.aida.model.CartItem;
import com.aida.model.Product;
import com.aida.model.User;

public interface CartService {
    public CartItem addCartItem(
            User user,
            Product product,
            String size,
            int quantity
    );

    public Cart findUserCart(User user);
}
