package com.aida.repository;

import com.aida.model.Cart;
import com.aida.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long id) ;
}
