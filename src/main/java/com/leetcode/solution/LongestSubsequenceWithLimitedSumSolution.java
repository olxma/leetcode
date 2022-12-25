package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>Longest Subsequence With Limited Sum</b>
 * <p>Level: <i>Easy</i></p>
 *
 * <p>You are given an integer array nums of length n, and an integer array queries of length m.</p>
 *
 * <p>Return an array answer of length m where answer[i] is the maximum size of a subsequence
 * that you can take from nums such that the sum of its elements is less than or equal to queries[i].</p>
 *
 * <p>A subsequence is an array that can be derived from another array by deleting some
 * or no elements without changing the order of the remaining elements.</p>
 *
 * @see <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/">
 * 2389. Longest Subsequence With Limited Sum</a>
 */
public class LongestSubsequenceWithLimitedSumSolution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int sum = 0;
            for (int n : nums) {
                if (sum + n <= query) {
                    sum += n;
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}
