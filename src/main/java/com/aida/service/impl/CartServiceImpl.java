package com.aida.service.impl;

import com.aida.model.Cart;
import com.aida.model.CartItem;
import com.aida.model.Product;
import com.aida.model.User;
import com.aida.repository.CartItemRepository;
import com.aida.repository.CartRepository;
import com.aida.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem addCartItem(User user, Product product, String size, int quantity) {
        Cart cart = findUserCart(user);
        CartItem  isPresent = cartItemRepository.findByCartAndProductAndSize(cart, product, size);

        if(isPresent == null){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setUserId(user.getId());
            cartItem.setSize(size);
            int totalPrice = quantity* product.getSellingPrice();
            cartItem.setSellingPrice(totalPrice);
            cart.getCartItems().add(cartItem);
            cartItem.setCart(cart);

            return cartItemRepository.save(cartItem);
        }

        return null;
    }

    @Override
    public Cart findUserCart(User user) {
        Cart cart = cartRepository.findByUserId(user.getId());

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        for(CartItem cartItem: cart.getCartItems()){
             totalPrice += cartItem.getMrpPrice();
             totalDiscountedPrice += cartItem.getSellingPrice();
             totalItem+=cartItem.getQuantity();
        }

        cart.setTotalMrpPrice(totalPrice);
        cart.setTotalItem(totalItem);
        cart.setTotalSellingPrice(totalDiscountedPrice);
        cart.setDiscount(calculateDiscountPercentage(totalPrice, totalDiscountedPrice));


        return cart;
    }

    private int calculateDiscountPercentage(int mrpPrice, int sellingPrice) {
        if(mrpPrice <= 0){
            throw new IllegalArgumentException("Actual price must be greater than 0");
        }
        double discount = mrpPrice-sellingPrice;
        double discountPercentage =(discount/mrpPrice)*100;
        System.out.println(discountPercentage);
        return (int)discountPercentage;
    }


}
