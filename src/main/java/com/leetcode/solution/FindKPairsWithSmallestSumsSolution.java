package com.leetcode.solution;

import java.util.*;

/**
 * <b>Find K Pairs with Smallest Sums</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.</p>
 *
 * <p>Define a pair (u, v) which consists of one element from the first array and one element from the second array.</p>
 *
 * <p>Return the k pairs
 * (u<sub>1</sub>, v<sub>1</sub>), (u<sub>2</sub>, v<sub>2</sub>), ..., (u<sub>k</sub>, v<sub>k</sub>)
 * with the smallest sums.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/">373. Find K Pairs with Smallest Sums</a>
 */
public class FindKPairsWithSmallestSumsSolution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int i : nums1) {
            queue.offer(new int[]{i + nums2[0], 0});
        }

        while (k-- > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int sum = pair[0];
            int pos2 = pair[1];
            int num1 = sum - nums2[pos2];
            int num2 = nums2[pos2];
            result.add(List.of(num1, num2));

            if (pos2 + 1 < nums2.length) {
                queue.offer(new int[]{num1 + nums2[pos2 + 1], pos2 + 1});
            }
        }

        return result;
    }
}
