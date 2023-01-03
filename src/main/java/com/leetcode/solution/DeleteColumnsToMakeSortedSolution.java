package com.leetcode.solution;

/**
 * <b>Delete Columns to Make Sorted</b>
 * <p>Level: <i>Easy</i></p>
 *
 * <p>You are given an array of n strings strs, all of the same length.</p>
 * <p>The strings can be arranged such that there is one on each line, making a grid.
 * For example, strs = ["abc", "bce", "cae"] can be arranged as:</p>
 * <pre>
 *     abc
 *     bce
 *     cae
 * </pre>
 * <p>You want to delete the columns that are not sorted lexicographically.
 * In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted
 * while column 1 ('b', 'c', 'a') is not, so you would delete column 1.</p>
 *
 * <p>Return the number of columns that you will delete.</p>
 *
 * @see <a href="https://leetcode.com/problems/delete-columns-to-make-sorted/description/">944. Delete Columns to Make Sorted</a>
 */
public class DeleteColumnsToMakeSortedSolution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int length = strs[0].length();
        int deleted = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    deleted++;
                    break;
                }
            }
        }

        return deleted;
    }
}
