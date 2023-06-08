package com.leetcode.solution;

/**
 * <b>Count Negative Numbers in a Sorted Matrix</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.</p>
 *
 * @see <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/">
 * 1351. Count Negative Numbers in a Sorted Matrix</a>
 */
public class CountNegativeNumbersInASortedMatrixSolution {
    public int countNegatives(int[][] grid) {
        int negatives = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    if (j == 0) {
                        negatives += (grid.length - i) * grid[i].length;
                        return negatives;
                    }
                    if (grid[i][j] < 0) negatives++;
                }
            }
        }
        return negatives;
    }
}
