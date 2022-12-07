package com.leetcode.util;

import com.leetcode.model.ListNode;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ListNodeConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && ListNode.class.isAssignableFrom(targetType)) {
            String[] split = ((String) source).split("\\s*,\\s*");
            return buildList(split);
        } else {
            throw new IllegalArgumentException(
                    String.format("Conversion from %s to %s not supported.", source.getClass(), targetType));
        }
    }

    private static ListNode buildList(String[] input) {
        if (input.length == 0) {
            return null;
        }
        ListNode head = new ListNode(Integer.parseInt(input[0]));
        ListNode next = head;
        for (int i = 1; i < input.length; i++) {
            next.next = new ListNode(Integer.parseInt(input[i]));
            next = next.next;
        }
        return head;
    }
}
