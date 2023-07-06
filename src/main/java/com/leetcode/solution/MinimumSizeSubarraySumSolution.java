package com.leetcode.solution;

/**
 * <b>Minimum Size Subarray Sum</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">209. Minimum Size Subarray Sum</a>
 */
public class MinimumSizeSubarraySumSolution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = -1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                int current = right - left + 1;
                min = min < 0 ? current : Math.min(min, current);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return Math.max(min, 0);
    }
}
