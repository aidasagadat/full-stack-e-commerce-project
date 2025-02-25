package com.aida.service;

import com.aida.domain.OrderStatus;
import com.aida.model.Address;
import com.aida.model.Cart;
import com.aida.model.Order;
import com.aida.model.User;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Set<Order> createOrder(User user, Address shippingAddress, Cart cart);
    Order findOrderById(long id) throws Exception;
    List<Order> userOrderHistory(Long userId);
    List<Order> sellersOrder(Long sellerId);
    Order updateOrderStatus(Long orderId, OrderStatus orderStatus) throws Exception;
    Order cancelOrder(Long orderId, User user);
}
