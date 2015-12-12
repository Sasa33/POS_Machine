package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;

public class SecondHalfPricePromotion extends Promotion{
    public double calculate(CartItem cartItem, double price) {
        int countOfTwoPieces = cartItem.getQuantity() / 2;
        int rest = cartItem.getQuantity() % 2;
        return (countOfTwoPieces * 1.5 + rest) * price;
    }
}
