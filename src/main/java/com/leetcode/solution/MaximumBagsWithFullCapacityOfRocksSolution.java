package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>Maximum Bags With Full Capacity of Rocks</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks.
 * The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks.
 * You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.</p>
 *
 * <p>Return the maximum number of bags that could have full capacity
 * after placing the additional rocks in some bags.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/">
 * 2279. Maximum Bags With Full Capacity of Rocks</a>
 */
public class MaximumBagsWithFullCapacityOfRocksSolution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= diff[i]) {
                additionalRocks -= diff[i];
                count++;
            }
            if (additionalRocks == 0) break;
        }
        return count;
    }
}
