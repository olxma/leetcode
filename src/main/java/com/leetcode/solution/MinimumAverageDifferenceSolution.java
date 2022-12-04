package com.leetcode.solution;

/**
 * <b>Minimum Average Difference</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a 0-indexed integer array nums of length n.</p>
 *
 * <p>The average difference of the index i is the absolute difference between
 * the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements.
 * Both averages should be rounded down to the nearest integer.</p>
 *
 * <p>Return the index with the minimum average difference.
 * If there are multiple such indices, return the smallest one.</p>
 *
 * <p>Note:</p>
 * <ul>
 *     <li>The absolute difference of two numbers is the absolute value of their difference.</li>
 *     <li>The average of n elements is the sum of the n elements divided (integer division) by n.</li>
 *     <li>The average of 0 elements is considered to be 0.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/minimum-average-difference/">2256. Minimum Average Difference</a>
 */
public class MinimumAverageDifferenceSolution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long totalSum = getTotalSum(nums);
        long memSum = 0;

        int minDiff = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            memSum += nums[i];

            long leftAvg = getLeftAvg(memSum, i);
            long rightAvg = getRightAvg(totalSum, memSum, n, i);

            int diff = getDiff(leftAvg, rightAvg);

            if (diff < minDiff) {
                minDiff = diff;
                result = i;
            }
        }
        return result;
    }

    private static long getTotalSum(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private static long getLeftAvg(long sum, int i) {
        return sum / (i + 1);
    }

    private static long getRightAvg(long totalSum, long leftSum, int n, int i) {
        long rightAvg = totalSum - leftSum;
        if (i != n - 1) {
            rightAvg /= (n - i - 1);
        }
        return rightAvg;
    }

    private static int getDiff(long leftAvg, long rightAvg) {
        return (int) Math.abs(leftAvg - rightAvg);
    }
}
