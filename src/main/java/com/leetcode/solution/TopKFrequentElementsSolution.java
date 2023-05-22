package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Top K Frequent Elements</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.</p>
 *
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
 */
public class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Entry> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Entry(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty() && index < res.length) {
            res[index++] = queue.poll().num;
        }
        return res;
    }

    private record Entry(int num, int count) {
    }
}
