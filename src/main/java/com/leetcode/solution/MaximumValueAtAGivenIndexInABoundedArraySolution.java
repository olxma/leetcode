package com.leetcode.solution;

/**
 * <b>Maximum Value at a Given Index in a Bounded Array</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed)
 * that satisfies the following conditions:</p>
 *
 * <ul>
 *     <li>nums.length == n</li>
 *     <li>nums[i] is a positive integer where 0 <= i < n.</li>
 *     <li>abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.</li>
 *     <li>The sum of all the elements of nums does not exceed maxSum.</li>
 *     <li>nums[index] is maximized.</li>
 * </ul>
 *
 * <p>Return nums[index] of the constructed array.</p>
 * <p>Note that abs(x) equals x if x >= 0, and -x otherwise.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/">
 * 1802. Maximum Value at a Given Index in a Bounded Array</a>
 */
public class MaximumValueAtAGivenIndexInABoundedArraySolution {
    public int maxValue(int n, int index, int maxSum) {
        int sum = n;
        int left = index;
        int right = index;
        int res = 1;

        while (sum + (right - left + 1) <= maxSum) {
            sum += right - left + 1;

            left = left == 0 ? 0 : left - 1;
            right = right == n - 1 ? right : right + 1;
            res++;

            if (left == 0 && right == n - 1) {
                int steps = (maxSum - sum) / n;
                sum += (steps * n);
                res += steps;
            }
        }
        return res;
    }
}
