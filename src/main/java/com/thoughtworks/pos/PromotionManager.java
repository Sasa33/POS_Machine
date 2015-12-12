package com.thoughtworks.pos;

import java.util.HashMap;
import java.util.Map;

public class PromotionManager {
    private Map<String, DiscountPromotion> discountPromotionMap = null;
    private Map<String, SecondHalfPricePromotion> secondHalfPricePromotionMap = null;

//    public PromotionManager(Map<String, DiscountPromotion> promotionMap) {
//        this.discountPromotionMap = promotionMap;
//    }
//
//    public PromotionManager(Map<String, SecondHalfPricePromotion> promotionMap) {
//        this.secondHalfPricePromotionMap = promotionMap;
//    }
//
//    public PromotionManager(Map<String, DiscountPromotion> promotionMap1, Map<String, SecondHalfPricePromotion> promotionMap2) {
//        this.discountPromotionMap = promotionMap1;
//        this.secondHalfPricePromotionMap = promotionMap2;
//    }


    public void setDiscountPromotionMap(Map<String, DiscountPromotion> discountPromotionMap) {
        this.discountPromotionMap = discountPromotionMap;
    }

    public void setSecondHalfPricePromotionMap(Map<String, SecondHalfPricePromotion> secondHalfPricePromotionMap) {
        this.secondHalfPricePromotionMap = secondHalfPricePromotionMap;
    }

    public DiscountPromotion getAvailableDiscountPromotion(String barcode) {
        return this.discountPromotionMap.get(barcode);
    }

    public SecondHalfPricePromotion getAvailableSecondHalfPromotion(String barcode) {return this.secondHalfPricePromotionMap.get(barcode);}
}
