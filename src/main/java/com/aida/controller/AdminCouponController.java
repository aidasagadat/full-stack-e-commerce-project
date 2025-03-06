package com.aida.controller;

import com.aida.model.Cart;
import com.aida.model.Coupon;
import com.aida.model.User;
import com.aida.response.ApiResponse;
import com.aida.service.CartService;
import com.aida.service.CouponService;
import com.aida.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/coupons")
public class AdminCouponController {
    private final CouponService couponService;
    private final UserService userService;
    private final CartService cartService;

    @PostMapping("/apply")
    public ResponseEntity<Cart> applyCoupon(
            @RequestParam String apply,
            @RequestParam String code,
            @RequestParam double orderValue,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart;

        if(apply.equals("true")){
            cart = couponService.applyCoupon(code, orderValue, user);
        }
        else {
            cart = couponService.removeCoupon(code, user);
        }
        return ResponseEntity.ok(cart);
    }

    // ADMIN OPERATIONS

    @PostMapping("/admin/create")
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon){
        Coupon createdCoupon = couponService.createCoupon(coupon);
        return ResponseEntity.ok(createdCoupon);
    }

    @DeleteMapping("/admin/delete/{couponId}")
    public ResponseEntity<ApiResponse> deleteCoupon(@PathVariable Long couponId) throws Exception {
        couponService.deleteCoupon(couponId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("coupon is deleted");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<Coupon>> getAllCoupons(){
        List<Coupon> coupons = couponService.findAllCoupons();
        return ResponseEntity.ok(coupons);
    }
}
