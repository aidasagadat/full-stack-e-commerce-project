package com.aida.service;

import com.aida.model.Product;
import com.aida.model.User;
import com.aida.model.WishList;

public interface WishlistService {
    WishList createWishlist(User user);
    WishList getWishlistByUserId(User user);
    WishList addProductToWishlist(User user, Product product);
}
