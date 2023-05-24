package com.leetcode.solution;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Maximum Subsequence Score</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
 * You must choose a subsequence of indices from nums1 of length k.</p>
 *
 * <p>For chosen indices i<sub>0</sub>, i<sub>1</sub>, ..., i<sub>k - 1</sub>, your score is defined as:</p>
 *
 * <ul>
 *     <li>The sum of the selected elements from nums1 multiplied
 *     with the minimum of the selected elements from nums2.</li>
 *     <li>It can defined simply as:
 *     (nums1[i<sub>0</sub>] + nums1[i<sub>1</sub>] +...+ nums1[i<sub>k - 1</sub>]) * min(nums2[i<sub>0</sub>] ,
 *     nums2[i<sub>1</sub>], ... ,nums2[i<sub>k - 1</sub>]).</li>
 * </ul>
 *
 * <p>Return the maximum possible score.</p>
 * <p>A subsequence of indices of an array is a set
 * that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.</p>
 *
 * @see <a href="link">2542. Maximum Subsequence Score</a>
 */
public class MaximumSubsequenceScoreSolution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] buff = new int[n][2];
        for (int i = 0; i < n; i++) {
            buff[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(buff, (a, b) -> b[0] - a[0]);
        Queue<Integer> queue = new PriorityQueue<>(k);
        long res = 0;
        long sum = 0;
        for (int[] es : buff) {
            queue.add(es[1]);
            sum = (sum + es[1]);
            if (queue.size() > k) sum -= queue.poll();
            if (queue.size() == k) res = Math.max(res, (sum * es[0]));
        }
        return res;
    }
}
