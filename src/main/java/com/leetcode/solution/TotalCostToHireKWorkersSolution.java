package com.leetcode.solution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>  Total Cost to Hire K Workers</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the i<sup>th</sup>worker.</p>
 *
 * <p>You are also given two integers k and candidates.
 * We want to hire exactly k workers according to the following rules:</p>
 *
 * <ul>
 *     <li>You will run k sessions and hire exactly one worker in each session.</li>
 *     <li>In each hiring session, choose the worker with the lowest cost from either the first candidates workers
 *     or the last candidates workers. Break the tie by the smallest index.</li>
 *     <li>
 *         <ul>
 *             <li>For example, if costs = [3,2,7,7,1,2] and candidates = 2,
 *             then in the first hiring session, we will choose the 4<sup>th</sup>worker
 *             because they have the lowest cost [3,2,7,7,1,2].</li>
 *             <li>In the second hiring session, we will choose 1st worker
 *             because they have the same lowest cost as 4<sup>th</sup>worker
 *             but they have the smallest index [3,2,7,7,2].
 *             Please note that the indexing may be changed in the process.</li>
 *          </ul>
 *     </li>
 *     <li>If there are fewer than candidates workers remaining,
 *     choose the worker with the lowest cost among them. Break the tie by the smallest index.</li>
 *     <li>A worker can only be chosen once.</li>
 * </ul>
 *
 * <p>Return the total cost to hire exactly k workers.</p>
 *
 * @see <a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/">
 * 2462. Total Cost to Hire K Workers</a>
 */
public class TotalCostToHireKWorkersSolution {
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> first = new PriorityQueue<>();
        Queue<Integer> last = new PriorityQueue<>();

        long totalCost = 0;
        int left = 0;
        int right = costs.length - 1;

        while (k-- > 0) {
            while (first.size() < candidates && left <= right) {
                first.offer(costs[left++]);
            }
            while (last.size() < candidates && left <= right) {
                last.offer(costs[right--]);
            }
            Integer firstCandidate = first.peek();
            Integer lastCandidate = last.peek();
            if (firstCandidate != null) {
                if (lastCandidate != null) {
                    if (firstCandidate <= lastCandidate) {
                        totalCost += first.poll();
                    } else {
                        totalCost += last.poll();
                    }
                } else {
                    totalCost += first.poll();
                }
            } else {
                totalCost += last.poll();
            }
        }

        return totalCost;
    }
}
