package com.thoughtworks.pos.parser;


import com.thoughtworks.pos.SecondHalfPricePromotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class SecondHalfPriceParser {
    private static final Pattern PATTERN = compile("^(\\w+)(\\d+)$");

    public Map<String, SecondHalfPricePromotion> parse(List<String> input) {
        Map<String, SecondHalfPricePromotion> secondHalfMap = new HashMap<>();
        for (String line : input) {
            validateInput(line);
            String[] splitLine = line.split(":");
            String barcode = splitLine[0];
            secondHalfMap.put(barcode, new SecondHalfPricePromotion());
        }
        return secondHalfMap;
    }

    private void validateInput(final String line) {
        if (!PATTERN.matcher(line).matches()) {
            throw new IllegalArgumentException("invalid input format");
        }
    }

//
//    @Override
//    protected SecondHalfPricePromotion parseLine(final String line) {
//        return new SecondHalfPricePromotion(line);
//    }
//
//    @Override
//    protected Pattern getPattern() {
//        return PATTERN;
//    }
}
