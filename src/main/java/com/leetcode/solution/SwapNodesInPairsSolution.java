package com.leetcode.solution;

import com.leetcode.model.ListNode;

/**
 * <b>Swap Nodes in Pairs</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)</p>
 *
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a>
 */
public class SwapNodesInPairsSolution {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private static ListNode swap(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) return node;
        ListNode first = node.next;
        ListNode third = node.next.next;
        first.next = node;
        node.next = swap(third);
        return first;
    }
}
