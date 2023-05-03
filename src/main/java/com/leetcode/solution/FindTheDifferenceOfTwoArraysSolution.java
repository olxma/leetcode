package com.leetcode.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <b>Find the Difference of Two Arrays</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:</p>
 *
 * <ul>
 *     <li>answer[0] is a list of all distinct integers in nums1 which are not present in nums2.</li>
 *     <li>answer[1] is a list of all distinct integers in nums2 which are not present in nums1.</li>
 * </ul>
 *
 * <p>Note that the integers in the lists may be returned in any order.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">
 * 2215. Find the Difference of Two Arrays</a>
 */
public class FindTheDifferenceOfTwoArraysSolution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        Set<Integer> buff = new HashSet<>(set1);
        set1.removeIf(set2::contains);
        set2.removeIf(buff::contains);

        return List.of(set1.stream().toList(), set2.stream().toList());
    }
}
