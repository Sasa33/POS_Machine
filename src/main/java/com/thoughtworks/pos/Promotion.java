package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;

public abstract class Promotion {
    public abstract double calculate(CartItem cartItem, double price);

//    public abstract
}
