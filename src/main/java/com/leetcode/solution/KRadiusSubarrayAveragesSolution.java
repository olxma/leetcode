package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>K Radius Subarray Averages</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a 0-indexed array nums of n integers, and an integer k.</p>
 * <p>The k-radius average for a subarray of nums centered at some index i with the radius k
 * is the average of all elements in nums between the indices i - k and i + k (inclusive).
 * If there are less than k elements before or after the index i, then the k-radius average is -1.</p>
 *
 * <p>Build and return an array avgs of length n where avgs[i] is the k-radius
 * average for the subarray centered at index i.</p>
 *
 * <p>The average of x elements is the sum of the x elements divided by x, using integer division.
 * The integer division truncates toward zero, which means losing its fractional part.</p>
 *
 * <ul>
 *     <li>For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75,
 *     which truncates to 2.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/k-radius-subarray-averages/">2090. K Radius Subarray Averages</a>
 */
public class KRadiusSubarrayAveragesSolution {
    public int[] getAverages(int[] nums, int k) {
        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        int d = 2 * k + 1;
        long sum = -1;
        for (int i = k; i < avg.length - k; i++) {
            if (sum < 0) {
                sum = 0;
                for (int j = i - k; j <= i + k; j++) {
                    sum += nums[j];
                }
            } else {
                sum -= nums[i - k - 1];
                sum += nums[i + k];
            }
            avg[i] = (int) (sum / d);
        }
        return avg;
    }
}
