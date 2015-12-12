package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.parser.DiscountParser;
import com.thoughtworks.pos.parser.ItemParser;
import com.thoughtworks.pos.parser.SecondHalfPriceParser;
import com.thoughtworks.pos.parser.ShoppingCartParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ItemParser itemParser = new ItemParser();
        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);
        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();
        List<CartItem> cartItems = shoppingCartParser.parse(ShopData.SHOPPING_CART_DATA);

        DiscountParser discountParser = new DiscountParser();
        Map<String, DiscountPromotion> discountPromotionMap = discountParser.parse(ShopData.DISCOUNT_ITEMS);

        SecondHalfPriceParser secondHalfParser = new SecondHalfPriceParser();
        Map<String, SecondHalfPricePromotion> secondHalfPromotionMap = secondHalfParser.parse(ShopData.SECOND_HALF_PRICE_ITEMS);

        PromotionManager promotionManager = new PromotionManager();
        promotionManager.setDiscountPromotionMap(discountPromotionMap);
        promotionManager.setSecondHalfPricePromotionMap(secondHalfPromotionMap);


        PosMachine posMachine = new PosMachine(allItems, promotionManager);

        double total = posMachine.calculate(cartItems);

        System.out.println("总价:" + total);
    }
}
