package com.leetcode.solution;

import com.leetcode.model.ListNode;

/**
 * <b>Middle of the Linked List</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given the head of a singly linked list {@link ListNode}, return the middle node of the linked list.</p>
 *
 * <p>If there are two middle nodes, return the second middle node.</p>
 *
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>
 */
public class MiddleOfTheLinkedListSolution {
    public ListNode middleNode(ListNode head) {
        ListNode middle = null;
        int middleIndex = -1;
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            int currentMiddleIndex = size / 2;
            if (middleIndex != currentMiddleIndex) {
                middle = middle == null ? node : middle.next;
                middleIndex++;
            }
            node = node.next;
        }
        return middle;
    }
}
