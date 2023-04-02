package com.leetcode.solution;

/**
 * <b>Binary Search</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.</p>
 *
 * <p>You must write an algorithm with O(log n) runtime complexity.</p>
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">704. Binary Search</a>
 */
public class BinarySearchSolution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
