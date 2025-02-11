package com.aida.service;

import com.aida.model.CartItem;

public interface CartItemService {
    CartItem updateCartItem(Long userId, Long id, CartItem cartItem);
    void removeCartItem(Long userId, Long cartItemId);
    CartItem findCartItemById(Long id);
}
