package com.leetcode.solution;

/**
 * <b>Longest Common Subsequence</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.</p>
 *
 * <p>A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of the remaining characters.</p>
 * <ul>
 *     <li>For example, "ace" is a subsequence of "abcde".</li>
 * </ul>
 * <p>A common subsequence of two strings is a subsequence that is common to both strings.</p>
 *
 * <p>Note: The idea of solution was taken from the
 * <a href="https://www.ics.uci.edu/~eppstein/161/960229.html">article</a>.</p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">1143. Longest Common Subsequence</a>
 */
public class LongestCommonSubsequenceSolution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] table = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0)
                    table[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[text1.length()][text2.length()];
    }
}
