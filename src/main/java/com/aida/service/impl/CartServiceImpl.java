package com.aida.service.impl;

import com.aida.model.Cart;
import com.aida.model.CartItem;
import com.aida.model.Product;
import com.aida.model.User;
import com.aida.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public CartItem addCartItem(User user, Product product, String size, int quantity) {
        return null;
    }

    @Override
    public Cart findUserCart(User user) {
        return null;
    }
}
