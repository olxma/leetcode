package com.leetcode.solution;

/**
 * <b>Minimize Maximum of Array</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a 0-indexed array nums comprising of n non-negative integers.</p>
 *
 * <p>In one operation, you must:</p>
 * <ul>
 *     <li>Choose an integer i such that 1 <= i < n and nums[i] > 0.</li>
 *     <li>Decrease nums[i] by 1.</li>
 *     <li>Increase nums[i - 1] by 1.</li>
 * </ul>
 *
 * <p>Return the minimum possible value of the maximum integer of nums after performing any number of operations.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimize-maximum-of-array/">2439. Minimize Maximum of Array</a>
 */
public class MinimizeMaximumOfArraySolution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int) res;
    }
}
