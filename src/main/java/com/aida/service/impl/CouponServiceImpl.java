package com.aida.service.impl;

import com.aida.model.Cart;
import com.aida.model.Coupon;
import com.aida.model.User;
import com.aida.repository.CartRepository;
import com.aida.repository.CouponRepository;
import com.aida.repository.UserRepository;
import com.aida.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public Cart applyCoupon(String code, double orderValue, User user) throws Exception {
        Coupon coupon = couponRepository.findByCode(code);

        Cart cart = cartRepository.findByUserId(user.getId());

        if(coupon==null){
            throw new Exception("Invalid coupon");
        }
        if(user.getUsedCoupons().contains(coupon)){
            throw new Exception("You have already used this coupon");
        }
        if(orderValue < coupon.getMinimumOrderValue()){
            throw new Exception("Total price is too low to apply the coupon");
        }

        if(coupon.isActive() && LocalDate.now().isAfter(coupon.getValidityStartDate())
            && LocalDate.now().isBefore(coupon.getValidityEndDate())
        ){
            user.getUsedCoupons().add(coupon);
            userRepository.save(user);

            double discountedPrice = (cart.getTotalSellingPrice()*coupon.getDiscountPercentage())/100;
            cart.setTotalSellingPrice(cart.getTotalSellingPrice()-discountedPrice);
            cart.setCouponCode(code);
            cartRepository.save(cart);
            return cart;
        }
        throw new Exception("Invalid coupon");
    }

    @Override
    public Cart removeCoupon(String code, User user) throws Exception {
        Coupon coupon = couponRepository.findByCode(code);
        if(coupon == null){
            throw new Exception("zcoupon not found");
        }
        Cart cart = cartRepository.findByUserId(user.getId());
        double discountedPrice = (cart.getTotalSellingPrice()*coupon.getDiscountPercentage())/100;
        cart.setTotalSellingPrice(cart.getTotalSellingPrice()+discountedPrice);
        cart.setCouponCode(null);
        return cartRepository.save(cart);
    }

    @Override
    public Coupon findCouponById(Long id) throws Exception {
        return couponRepository.findById(id).orElseThrow(() -> new Exception("coupon not found"));
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return null;
    }

    @Override
    public List<Coupon> findAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public void deleteCoupon(Long id) {

    }
}
