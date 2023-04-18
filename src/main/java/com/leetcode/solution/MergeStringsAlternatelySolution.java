package com.leetcode.solution;

/**
 * <b>Merge Strings Alternately</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other,
 * append the additional letters onto the end of the merged string.</p>
 *
 * <p>Return the merged string.</p>
 *
 * @see <a href="https://leetcode.com/problems/merge-strings-alternately/">1768. Merge Strings Alternately</a>
 */
public class MergeStringsAlternatelySolution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                builder.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                builder.append(word2.charAt(j++));
            }
        }

        return builder.toString();
    }
}
