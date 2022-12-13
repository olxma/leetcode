package com.leetcode.solution;

/**
 * <b>Minimum Falling Path Sum</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.</p>
 *
 * <p>A falling path starts at any element in the first row and chooses the element in the next row
 * that is either directly below or diagonally left/right.
 * Specifically the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col),
 * or (row + 1, col + 1).</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-falling-path-sum/">931. Minimum Falling Path Sum</a>
 */
public class MinimumFallingPathSumSolution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = new int[len][matrix[0].length];
        System.arraycopy(matrix[0], 0, temp[0], 0, matrix[0].length);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (j == 0) {
                    temp[i][j] = current + min(temp[i - 1][j], temp[i - 1][j + 1]);
                } else if (j + 1 == matrix[i].length) {
                    temp[i][j] = current + min(temp[i - 1][j], temp[i - 1][j - 1]);
                } else {
                    temp[i][j] = current + min(temp[i - 1][j], temp[i - 1][j - 1], temp[i - 1][j + 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < temp[len - 1].length; j++) {
            min = min(min, temp[len - 1][j]);
        }
        return min;
    }

    private static int min(int a, int b) {
        return Math.min(a, b);
    }

    private static int min(int a, int b, int c) {
        return min(a, min(b, c));
    }
}
