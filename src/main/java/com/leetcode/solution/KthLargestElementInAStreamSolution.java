package com.leetcode.solution;

import java.util.*;

/**
 * <b>Kth Largest Element in a Stream</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Design a class to find the k<sup>th</sup> largest element in a stream.
 * Note that it is the k<sup>th</sup> largest element in the sorted order, not the k<sup>th</sup> distinct element.</p>
 *
 * <p>Implement KthLargest class:</p>
 * <ul>
 *     <li>KthLargest(int k, int[] nums) Initializes the object with the integer k
 *     and the stream of integers nums.</li>
 *     <li>int add(int val) Appends the integer val to the stream
 *     and returns the element representing the k<sup>th</sup> largest element in the stream.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">
 *     703. Kth Largest Element in a Stream</a>
 */
public class KthLargestElementInAStreamSolution {
    private final int k;
    private final Queue<Integer> queue;

    public KthLargestElementInAStreamSolution(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (this.queue.isEmpty() || this.queue.size() < k) {
            this.queue.add(val);
        } else if (val > this.queue.peek()) {
            this.queue.poll();
            this.queue.add(val);
        }
        return this.queue.peek();
    }
}
