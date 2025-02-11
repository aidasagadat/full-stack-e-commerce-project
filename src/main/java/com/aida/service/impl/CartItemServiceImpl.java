package com.aida.service.impl;

import com.aida.model.CartItem;
import com.aida.service.CartItemService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) {

    }

    @Override
    public CartItem findCartItemById(Long id) {
        return null;
    }
}
