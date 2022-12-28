package com.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Remove Stones to Minimize the Total</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You are given a 0-indexed integer array piles,
 * where piles[i] represents the number of stones in the i<sup>th</sup> pile, and an integer k.
 * You should apply the following operation exactly k times:</p>
 *
 * <ul><li>Choose any piles[i] and remove floor(piles[i] / 2) stones from it.</li></ul>
 *
 * <p>Notice that you can apply the operation on the same pile more than once.</p>
 * <p>Return the minimum possible total number of stones remaining after applying the k operations.</p>
 * <p>floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).</p>
 *
 * @see <a href="https://leetcode.com/problems/remove-stones-to-minimize-the-total/">
 * 1962. Remove Stones to Minimize the Total</a>
 */
public class RemoveStonesToMinimizeTheTotalSolution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            queue.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) break;
            queue.offer((int) Math.ceil(queue.poll() / 2d));
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}
