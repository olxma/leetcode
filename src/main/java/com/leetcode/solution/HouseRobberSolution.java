package com.leetcode.solution;

/**
 * <b>House Robber</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
 * each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.</p>
 *
 * <p>Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.</p>
 *
 * @see <a href="https://leetcode.com/problems/house-robber/">198. House Robber</a>
 */
public class HouseRobberSolution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] buffer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            buffer[i] = Math.max(
                    current + getFromArray(buffer, i - 2),
                    current + getFromArray(buffer, i - 3));
        }
        return Math.max(buffer[buffer.length - 1], buffer[buffer.length - 2]);
    }

    private static int getFromArray(int[] buffer, int i) {
        return i >= 0 ? buffer[i] : 0;
    }
}
