package com.aida.service;

import com.aida.model.Order;
import com.aida.model.PaymentOrder;
import com.aida.model.User;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;

import java.util.Set;

public interface PaymentService {
    PaymentOrder createOrder(User user, Set<Order> orders);
    PaymentOrder getPaymentOrderById(Long orderId) throws Exception;
    PaymentOrder getPaymentOrderByPaymentId(String orderId) throws Exception;
    Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId, String paymentLinkId);
    String createStripePaymentLink(User user, Long amount, Long orderId) throws StripeException;

}

















