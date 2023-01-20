package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <b>Non-decreasing Subsequences</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an integer array nums, return all the different possible non-decreasing subsequences
 * of the given array with at least two elements. You may return the answer in any order.</p>
 *
 * @see <a href="https://leetcode.com/problems/non-decreasing-subsequences/">
 * 491. Non-decreasing Subsequences</a>
 */
public class NonDecreasingSubsequencesSolution {
    private int[] nums;
    private Set<List<Integer>> result;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        this.result = new HashSet<>();

        find(0, new ArrayList<>());
        return result.stream().toList();
    }

    private void find(int i, List<Integer> sequence) {
        if (i == nums.length) {
            if (sequence.size() >= 2) {
                result.add(new ArrayList<>(sequence));
            }
            return;
        }
        if (sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[i]) {
            sequence.add(nums[i]);
            find(i + 1, sequence);
            sequence.remove(sequence.size() - 1);
        }
        find(i + 1, sequence);
    }
}
