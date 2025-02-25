package com.aida.controller;

import com.aida.model.Cart;
import com.aida.model.CartItem;
import com.aida.model.Product;
import com.aida.model.User;
import com.aida.request.AddItemRequest;
import com.aida.response.ApiResponse;
import com.aida.service.CartItemService;
import com.aida.service.CartService;
import com.aida.service.ProductService;
import com.aida.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final CartItemService cartItemService;
    private final UserService userService;
    private final ProductService productService;

    public CartController(CartService cartService, CartItemService cartItemService, UserService userService, ProductService productService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Cart cart = cartService.findUserCart(user);

        System.out.println("cart - " + cart.getUser().getEmail());

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);

    }

    @PutMapping("/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Product product = productService.findProductById(req.getProductId());

        CartItem item = cartService.addCartItem(user, product, req.getSize(), req.getQuantity());
        ApiResponse res = new ApiResponse();
        res.setMessage("Item added to cart");

        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/item/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteItemFromCartHandler(@PathVariable long cartItemId,
                                                                 @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Item deleted from cart");
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @PutMapping("/item/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItemHandler(@PathVariable long cartItemId,
                                                             @RequestHeader("Authorization") String jwt, @RequestBody CartItem cartItem) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        CartItem updatedItem = new CartItem();
        if(cartItem.getQuantity() > 0){
            updatedItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
        }
        return new ResponseEntity<>(updatedItem, HttpStatus.ACCEPTED);
    }

}
