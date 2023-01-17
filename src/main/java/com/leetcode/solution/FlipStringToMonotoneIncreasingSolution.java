package com.leetcode.solution;

/**
 * <b>Flip String to Monotone Increasing</b>
 * <p>Level: <i>Medium</i></p>
 * <p>A binary string is monotone increasing if it consists of some number of 0's (possibly none),
 * followed by some number of 1's (also possibly none).</p>
 *
 * <p>You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.</p>
 *
 * <p>Return the minimum number of flips to make s monotone increasing.</p>
 *
 * @see <a href="https://leetcode.com/problems/flip-string-to-monotone-increasing/description/">
 * 926. Flip String to Monotone Increasing</a>
 */
public class FlipStringToMonotoneIncreasingSolution {
    public int minFlipsMonoIncr(String s) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                result = Math.min(count, result + 1);
            } else {
                count++;
            }
        }
        return result;
    }
}
