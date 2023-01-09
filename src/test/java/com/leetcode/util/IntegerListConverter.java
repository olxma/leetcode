package com.leetcode.util;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayList;
import java.util.List;

public class IntegerListConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && List.class.isAssignableFrom(targetType)) {
            String[] split = ((String) source).split("\\s*,\\s*");
            List<Integer> result = new ArrayList<>();
            for (String s : split) {
                if (!"null".equals(s)) {
                    result.add(Integer.parseInt(s));
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException(
                    String.format("Conversion from %s to %s not supported.", source.getClass(), targetType));
        }
    }
}
