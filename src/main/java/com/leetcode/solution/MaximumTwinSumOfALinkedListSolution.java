package com.leetcode.solution;

import com.leetcode.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b>Maximum Twin Sum of a Linked List</b>
 * <p>Level: <i>Medium</i></p>
 * <p>In a linked list of size n, where n is even, the i<sup>th</sup> node (0-indexed) of the linked list is known
 * as the twin of the (n-1-i)<sup>th</sup> node, if 0 <= i <= (n / 2) - 1.</p>
 *
 * <ul>
 *     <li>For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
 *     These are the only nodes with twins for n = 4.</li>
 * </ul>
 *
 * <p>The twin sum is defined as the sum of a node and its twin.</p>
 * <p>Given the head of a linked list with even length, return the maximum twin sum of the linked list.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">
 * 2130. Maximum Twin Sum of a Linked List</a>
 */
public class MaximumTwinSumOfALinkedListSolution {
    public int pairSum(ListNode head) {
        int max = 0;
        Deque<ListNode> queue = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            queue.addLast(node);
            node = node.next;
        }
        while (!queue.isEmpty()) {
            ListNode first = queue.pollFirst();
            ListNode last = queue.pollLast();
            max = Math.max(max, first.val + last.val); // we assume the number of nodes is always even, so there won't be NPE here
        }
        return max;
    }
}
