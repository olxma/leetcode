package com.leetcode.util;

import com.leetcode.model.ListNode;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestUtil {
    public static ListNode listNodeOf(@NonNull int... input) {
        if (input.length == 0) {
            return null;
        }
        ListNode head = new ListNode(input[0]);
        ListNode next = head;
        for (int i = 1; i < input.length; i++) {
            next.next = new ListNode(input[i]);
            next = next.next;
        }
        return head;
    }
}
