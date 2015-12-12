package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.Item;

import java.util.List;

public final class PosMachine {
    private final List<Item> allItems;
    private final PromotionManager promotionManager;
//    private final PromotionManager promotionManager2;

//    public PosMachine(final List<Item> allItems, PromotionManager promotionManager, PromotionManager promotionManager2) {
//        this.allItems = allItems;
//        this.promotionManager = promotionManager;
//        this.promotionManager2 = promotionManager2;
//    }

    public PosMachine(final List<Item> allItems, PromotionManager promotionManager) {
        this.allItems = allItems;
        this.promotionManager = promotionManager;
//        this.promotionManager2 = null;
    }

    public double calculate(final List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += calculateSubtotal(cartItem);
        }
        return total;
    }

//    private double calculateSubtotal(final CartItem cartItem) {
//        String barcode = cartItem.getBarcode();
//        double originPrice = queryItemPrice(barcode);
//        Promotion availablePromotion = promotionManager.getAvailablePromotion(barcode);
//        double subtotal = (availablePromotion != null) ? availablePromotion.calculate(cartItem, originPrice) : cartItem.getQuantity() * originPrice;
//        return subtotal;
//    }

    private double calculateSubtotal(final CartItem cartItem) {
        String barcode = cartItem.getBarcode();
        double originPrice = queryItemPrice(barcode);
        DiscountPromotion availableDiscountPromotion = promotionManager.getAvailableDiscountPromotion(barcode);
        double newPrice = (availableDiscountPromotion != null)
                ? (originPrice * availableDiscountPromotion.getDiscountRatio()) : originPrice;
        SecondHalfPricePromotion availableSecondHalfPromotion = promotionManager.getAvailableSecondHalfPromotion(barcode);
        double subtotal = (availableSecondHalfPromotion != null)
                ? availableSecondHalfPromotion.calculate(cartItem, newPrice)
                : availableDiscountPromotion.calculate(cartItem, originPrice);
        return subtotal;
    }

    private double queryItemPrice(final String barcode) {
        for (Item item : allItems) {
            if (item.getBarcode().equals(barcode)) {
                return item.getPrice();
            }
        }

        throw new IllegalArgumentException("unknown item");
    }
}
