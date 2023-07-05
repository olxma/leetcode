package com.leetcode.solution;

/**
 * <b>Longest Subarray of 1's After Deleting One Element</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a binary array nums, you should delete one element from it.</p>
 * <p>Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.</p>
 *
 * @see <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">
 * 1493. Longest Subarray of 1's After Deleting One Element</a>
 */
public class LongestSubarrayOf1sAfterDeletingOneElementSolution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zeros = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            result = Math.max(result, right - left + 1 - zeros);
        }
        return (result == n) ? result - 1 : result;
    }
}
