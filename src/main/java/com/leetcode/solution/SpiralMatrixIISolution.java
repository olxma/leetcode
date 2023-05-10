package com.leetcode.solution;

/**
 * <b>Spiral Matrix II</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a positive integer n, generate an n x n matrix
 * filled with elements from 1 to n<sup>2</sup> in spiral order.</p>
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/">59. Spiral Matrix II</a>
 */
public class SpiralMatrixIISolution {
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;

    private int[][] array;
    private int topEdge;
    private int bottomEdge;
    private int leftEdge;
    private int rightEdge;

    public int[][] generateMatrix(int n) {
        this.array = new int[n][n];
        this.topEdge = 1;
        this.bottomEdge = n - 1;
        this.leftEdge = 0;
        this.rightEdge = n - 1;
        spiralFillArray(0, 0, 1, RIGHT);
        return array;
    }

    private void spiralFillArray(int i, int j, int num, int direction) {
        array[i][j] = num;
        switch (direction) {
            case 1 -> {
                if (j + 1 <= rightEdge) {
                    spiralFillArray(i, j + 1, ++num, direction);
                } else if (i + 1 <= bottomEdge) {
                    rightEdge--;
                    spiralFillArray(i + 1, j, ++num, DOWN);
                }
            }
            case 2 -> {
                if (i + 1 <= bottomEdge) {
                    spiralFillArray(i + 1, j, ++num, direction);
                } else if (j - 1 >= leftEdge) {
                    bottomEdge--;
                    spiralFillArray(i, j - 1, ++num, LEFT);
                }
            }
            case 3 -> {
                if (j - 1 >= leftEdge) {
                    spiralFillArray(i, j - 1, ++num, direction);
                } else if (i - 1 >= topEdge) {
                    leftEdge++;
                    spiralFillArray(i - 1, j, ++num, UP);
                }
            }
            default -> {
                if (i - 1 >= topEdge) {
                    spiralFillArray(i - 1, j, ++num, direction);
                } else if (j + 1 <= rightEdge) {
                    topEdge++;
                    spiralFillArray(i, j + 1, ++num, RIGHT);
                }
            }
        }
    }
}
