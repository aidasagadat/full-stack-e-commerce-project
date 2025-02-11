package com.aida.repository;

import com.aida.model.Cart;
import com.aida.model.CartItem;
import com.aida.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);

}
