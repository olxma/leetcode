package com.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Last Stone Weight</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are given an array of integers stones where stones[i] is the weight of the i<sup>th</sup> stone.</p>
 *
 * <p>We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:</p>
 * <ul>
 *     <li>If x == y, both stones are destroyed, and</li>
 *     <li>f x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.</li>
 * </ul>
 *
 * <p>At the end of the game, there is at most one stone left.</p>
 * <p>Return the weight of the last remaining stone. If there are no stones left, return 0.</p>
 *
 * @see <a href="https://leetcode.com/problems/last-stone-weight/">1046. Last Stone Weight</a>
 */
public class LastStoneWeightSolution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            if (x > y) {
                queue.add(x - y);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
