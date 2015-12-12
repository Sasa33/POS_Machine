package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;

import java.util.Map;

public class DiscountPromotion extends Promotion{
    private final double discountRatio;

    public DiscountPromotion(int discount) {
        this.discountRatio = discount / 100d;
    }

    public double calculate(CartItem cartItem, double price) {
        return cartItem.getQuantity() * price * this.discountRatio ;
    }
//
//    public double applyDiscount(Map<String, DiscountPromotion> discountPromotionMap) {
//
//    }

    public double getDiscountRatio() {
        return discountRatio;
    }
}
