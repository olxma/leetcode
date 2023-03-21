package com.leetcode.solution;

/**
 * <b>Number of Zero-Filled Subarrays</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an integer array nums, return the number of subarrays filled with 0.</p>
 *
 * <p>A subarray is a contiguous non-empty sequence of elements within an array.</p>
 *
 * @see <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">
 * 2348. Number of Zero-Filled Subarrays</a>
 */
public class NumberOfZeroFilledSubarraysSolution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j = i + 1;
            }
            res += i - j + 1;
        }
        return res;
    }
}
