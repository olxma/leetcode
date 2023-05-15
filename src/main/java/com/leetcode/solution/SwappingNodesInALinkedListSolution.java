package com.leetcode.solution;

import com.leetcode.model.ListNode;

/**
 * <b>Swapping Nodes in a Linked List</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given the head of a linked list, and an integer k.</p>
 *
 * <p>Return the head of the linked list after swapping the values of the k<sup>th</sup> node from the beginning
 * and the k<sup>th</sup> node from the end (the list is 1-indexed).</p>
 *
 * @see <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">
 * 1721. Swapping Nodes in a Linked List</a>
 */
public class SwappingNodesInALinkedListSolution {
    public ListNode swapNodes(ListNode head, int k) {
        int total = 0;
        ListNode node = head;
        while (node != null) {
            total++;
            node = node.next;
        }
        int rightIndex = total - k + 1;
        if (k == rightIndex) return head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        node = head;
        int index = 1;
        while (node != null) {
            if (index == k) {
                leftNode = node;
            }
            if (index == rightIndex) {
                rightNode = node;
            }
            node = node.next;
            index++;
        }
        swapValues(leftNode, rightNode);
        return head;
    }

    private static void swapValues(ListNode left, ListNode right) {
        left.val += right.val;
        right.val = left.val - right.val;
        left.val -= right.val;
    }
}
