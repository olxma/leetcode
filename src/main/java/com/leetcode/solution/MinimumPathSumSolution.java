package com.leetcode.solution;

/**
 * <b>Minimum Path Sum</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.</p>
 *
 * <p>Note: You can only move either down or right at any point in time.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/">64. Minimum Path Sum</a>
 */
public class MinimumPathSumSolution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                if (i == 0 && j == 0) {
                    result[i][j] = x;
                } else if (i == 0) {
                    result[i][j] = x + result[i][j - 1];
                } else if (j == 0) {
                    result[i][j] = x + result[i - 1][j];
                } else {
                    result[i][j] = Math.min(x + result[i][j - 1], x + result[i - 1][j]);
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
