package com.aida.controller;

import com.aida.service.CartService;
import com.aida.service.CouponService;
import com.aida.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AdminCouponController {
    private final CouponService couponService;
    private final UserService userService;
    private final CartService cartService;
}
