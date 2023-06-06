package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>Can Make Arithmetic Progression From Sequence</b>
 * <p>Level: <i>Easy</i></p>
 * <p>A sequence of numbers is called an arithmetic progression
 * if the difference between any two consecutive elements is the same.</p>
 *
 * <p>Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression.
 * Otherwise, return false.</p>
 *
 * @see <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/">
 * 1502. Can Make Arithmetic Progression From Sequence</a>
 */
public class CanMakeArithmeticProgressionFromSequenceSolution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) return false;
        }
        return true;
    }
}
