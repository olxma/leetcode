package com.leetcode.solution;

import java.util.*;

/**
 * <b>Smallest Number in Infinite Set</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].</p>
 *
 * <p>Implement the SmallestInfiniteSet class:</p>
 * <ul>
 *     <li>SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.</li>
 *     <li>int popSmallest() Removes and returns the smallest integer contained in the infinite set.</li>
 *     <li>void addBack(int num) Adds a positive integer num back into the infinite set,
 *     if it is not already in the infinite set.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">
 * 2336. Smallest Number in Infinite Set</a>
 */
public class SmallestNumberInInfiniteSetSolution {
    private int pointer;
    private final Set<Integer> set;
    private final Queue<Integer> queue;

    public SmallestNumberInInfiniteSetSolution() {
        this.pointer = 1;
        this.set = new HashSet<>();
        this.queue = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (queue.isEmpty() || queue.peek() > pointer) {
            return pointer++;
        } else {
            Integer num = queue.poll();
            set.remove(num);
            return num;
        }
    }

    public void addBack(int num) {
        if (num < pointer && !set.contains(num)) {
            set.add(num);
            queue.add(num);
        }
    }
}
