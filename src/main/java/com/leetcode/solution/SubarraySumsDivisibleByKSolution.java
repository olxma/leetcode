package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Subarray Sums Divisible by K</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an integer array nums and an integer k,
 * return the number of non-empty subarrays that have a sum divisible by k.</p>
 *
 * <p>A subarray is a contiguous part of an array.</p>
 *
 * @see <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">
 * 974. Subarray Sums Divisible by K</a>
 */
public class SubarraySumsDivisibleByKSolution {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int remainder;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) nums[i] += nums[i - 1];
            remainder = (nums[i] % k + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        int result = map.getOrDefault(0, 0);
        for (int frequency : map.values())
            result += frequency * (frequency - 1) / 2;
        return result;
    }
}
