package com.leetcode.solution;

/**
 * <b>Removing Stars From a String</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a string s, which contains stars *.</p>
 * <p>In one operation, you can:</p>
 * <ul>
 *     <li>Choose a star in s.</li>
 *     <li>Remove the closest non-star character to its left, as well as remove the star itself.</li>
 * </ul>
 *
 * <p>Return the string after all stars have been removed.</p>
 * <p>Note:</p>
 * <ul>
 *     <li>The input will be generated such that the operation is always possible.</li>
 *     <li>It can be shown that the resulting string will always be unique.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/removing-stars-from-a-string/">
 * 2390. Removing Stars From a String</a>
 */
public class RemovingStarsFromAStringSolution {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
