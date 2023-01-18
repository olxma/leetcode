package com.leetcode.solution;

/**
 * <b>Maximum Sum Circular Subarray</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a circular integer array nums of length n,
 * return the maximum possible sum of a non-empty subarray of nums.</p>
 *
 * <p>A circular array means the end of the array connects to the beginning of the array.
 * Formally, the next element of nums[i] is nums[(i + 1) % n]
 * and the previous element of nums[i] is nums[(i - 1 + n) % n].</p>
 *
 * <p>A subarray may only include each element of the fixed buffer nums at most once.
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
 * there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-sum-circular-subarray/">
 * 918. Maximum Sum Circular Subarray</a>
 */
public class MaximumSumCircularSubarraySolution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = 0;
        int min = 0;
        int sum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int num : nums) {
            max = Math.max(max, 0) + num;
            maxSum = Math.max(maxSum, max);
            min = Math.min(min, 0) + num;
            minSum = Math.min(minSum, min);
            sum += num;
        }

        if (sum == minSum) {
            sum = maxSum;
        } else {
            sum = Math.max(maxSum, sum - minSum);
        }
        return sum;
    }
}
