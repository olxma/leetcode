package com.leetcode.util;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntegerArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
            String[] split = ((String) source).split("\\s*,\\s*");
            int[] result = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                result[i] = Integer.parseInt(split[i]);
            }
            return result;
        } else {
            throw new IllegalArgumentException(
                    String.format("Conversion from %s to %s not supported.", source.getClass(), targetType));
        }
    }
}
