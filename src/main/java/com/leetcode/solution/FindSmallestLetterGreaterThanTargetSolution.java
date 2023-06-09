package com.leetcode.solution;

/**
 * <b>Find Smallest Letter Greater Than Target</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
 * There are at least two different characters in letters.</p>
 *
 * <p>Return the smallest character in letters that is lexicographically greater than target.
 * If such a character does not exist, return the first character in letters.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">
 *     744. Find Smallest Letter Greater Than Target</a>
 */
public class FindSmallestLetterGreaterThanTargetSolution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }
}
