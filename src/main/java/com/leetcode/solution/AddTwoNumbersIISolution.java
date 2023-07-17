package com.leetcode.solution;

import com.leetcode.model.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Add Two Numbers II</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.</p>
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
 *
 * @see <a href="https://leetcode.com/problems/add-two-numbers-ii/">445. Add Two Numbers II</a>
 */
public class AddTwoNumbersIISolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        ListNode first = l1;
        ListNode second = l2;
        while (first != null) {
            q1.offer(first.val);
            first = first.next;
        }
        while (second != null) {
            q2.offer(second.val);
            second = second.next;
        }
        Deque<Integer> sum = new ArrayDeque<>();
        int r = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int s = q1.pollLast() + q2.pollLast() + r;
            r = s / 10;
            sum.addFirst(s % 10);
        }
        while (!q1.isEmpty()) {
            int s = q1.pollLast() + r;
            r = s / 10;
            sum.addFirst(s % 10);
        }

        while (!q2.isEmpty()) {
            int s = q2.pollLast() + r;
            r = s / 10;
            sum.addFirst(s % 10);
        }

        if (r > 0) {
            sum.addFirst(r);
        }

        ListNode root = new ListNode(sum.pollFirst());
        ListNode node = root;
        while (!sum.isEmpty()) {
            node.next = new ListNode(sum.pollFirst());
            node = node.next;
        }
        return root;
    }
}
