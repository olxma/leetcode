package com.leetcode.solution;

import com.leetcode.model.ListNode;

/**
 * <b>Odd Even Linked List</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given the head of a singly linked list {@link ListNode},
 * group all the nodes with odd indices together followed by the nodes with even indices,
 * and return the reordered list.</p>
 *
 * <p>The first node is considered odd, and the second node is even, and so on.</p>
 * <p>Note that the relative order inside both the even and odd groups should remain as it was in the input.</p>
 * <p>You must solve the problem in O(1) extra space complexity and O(n) time complexity.</p>
 *
 * @see <a href="https://leetcode.com/problems/odd-even-linked-list/">328. Odd Even Linked List</a>
 */
public class OddEvenLinkedListSolution {
    public ListNode oddEvenList(ListNode head) {
        int currentIndex = 1;
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode oddTail = null;

        ListNode node = head;
        while (node != null) {
            if (isOdd(currentIndex)) {
                oddTail = setNext(oddTail, node);
            } else {
                if (evenHead == null) {
                    evenHead = node;
                }
                evenTail = setNext(evenTail, node);
            }
            node = node.next;
            currentIndex++;
        }

        join(oddTail, evenHead, evenTail);
        return head;
    }

    private static void join(ListNode oddTail, ListNode evenHead, ListNode evenTail) {
        if (oddTail != null) {
            oddTail.next = evenHead;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
    }

    /**
     * Set next link if tail is not null and return current element
     *
     * @param tail of the linked list
     * @param node of current element
     * @return current node
     */
    private static ListNode setNext(ListNode tail, ListNode node) {
        if (tail != null) {
            tail.next = node;
        }
        return node;
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
