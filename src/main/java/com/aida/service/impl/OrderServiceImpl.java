package com.aida.service.impl;

import com.aida.domain.OrderStatus;
import com.aida.domain.PaymentStatus;
import com.aida.model.*;
import com.aida.repository.AddressRepository;
import com.aida.repository.OrderItemRepository;
import com.aida.repository.OrderRepository;
import com.aida.service.OrderService;

import java.util.*;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, AddressRepository addressRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Set<Order> createOrder(User user, Address shippingAddress, Cart cart) {
        return Set.of();
    }

    @Override
    public Order findOrderById(long id) {
        return null;
    }

    @Override
    public List<Order> userOrderHistory(Long userId) {
        return List.of();
    }

    @Override
    public List<Order> sellersOrder(Long sellerId) {
        return List.of();
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        return null;
    }

    @Override
    public Order cancelOrder(Long orderId, User user) {
        return null;
    }
}
