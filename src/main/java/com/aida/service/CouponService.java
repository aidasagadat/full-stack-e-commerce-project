package com.aida.service;

import com.aida.model.Cart;
import com.aida.model.Coupon;
import com.aida.model.User;

import java.util.List;

public interface CouponService {
    Cart applyCoupon(String code, double orderValue, User user) throws Exception;
    Cart removeCoupon(String code, User user);
    Coupon findCouponById(Long id);
    Coupon createCoupon(Coupon coupon);
    List<Coupon> findAllCoupons();
    void deleteCoupon(Long id);
}
