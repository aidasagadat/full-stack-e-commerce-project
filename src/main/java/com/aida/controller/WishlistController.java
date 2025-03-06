package com.aida.controller;

import com.aida.exception.ProductException;
import com.aida.model.Product;
import com.aida.model.User;
import com.aida.model.WishList;
import com.aida.service.ProductService;
import com.aida.service.UserService;
import com.aida.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<WishList> getWishlistByUserId(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        WishList wishList = wishlistService.getWishlistByUserId(user);
        return ResponseEntity.ok(wishList);
    }

    @PostMapping("/add-product/{productId}")
    public ResponseEntity<WishList> addProductToWishlist(@PathVariable Long productId, @RequestHeader("Authorization") String jwt) throws Exception {

        Product product = productService.findProductById(productId);
        User user = userService.findUserByJwtToken(jwt);
        WishList updatedWishlist = wishlistService.addProductToWishlist(user, product);

        return ResponseEntity.ok(updatedWishlist);

    }

}










