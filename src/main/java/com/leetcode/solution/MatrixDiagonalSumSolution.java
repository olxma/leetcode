package com.leetcode.solution;

/**
 * <b>Matrix Diagonal Sum</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given a square matrix mat, return the sum of the matrix diagonals.</p>
 *
 * <p>Only include the sum of all the elements on the primary diagonal
 * and all the elements on the secondary diagonal that are not part of the primary diagonal.</p>
 *
 * @see <a href="https://leetcode.com/problems/matrix-diagonal-sum/">1572. Matrix Diagonal Sum</a>
 */
public class MatrixDiagonalSumSolution {
    public int diagonalSum(int[][] mat) {
        boolean isLengthOdd = mat.length % 2 != 0;
        int sum = getSum(mat);
        if (isLengthOdd) {
            sum -= mat[(mat.length - 1) / 2][(mat.length - 1) / 2];
        }
        return sum;
    }

    private static int getSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            sum += mat[mat.length - 1 - i][i];
        }
        return sum;
    }
}
