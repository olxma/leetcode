package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Spiral Matrix</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an m x n matrix, return all elements of the matrix in spiral order.</p>
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">54. Spiral Matrix</a>
 */
public class SpiralMatrixSolution {
    private static final int GO_RIGHT = 1;
    private static final int GO_DOWN = 2;
    private static final int GO_LEFT = 3;
    private static final int GO_UP = 4;
    private int[][] matrix;
    private List<Integer> result;
    private int top;
    private int left;
    private int down;
    private int right;

    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        this.result = new ArrayList<>();
        this.top = 1;
        this.left = 0;
        this.down = matrix.length - 1;
        this.right = matrix[0].length - 1;
        traverse(0, 0, GO_RIGHT);
        return result;
    }

    private void traverse(int i, int j, int direction) {
        this.result.add(matrix[i][j]);
        switch (direction) {
            case 1 -> {
                if (j + 1 <= right) {
                    traverse(i, j + 1, direction);
                } else if (i + 1 <= down) {
                    right--;
                    traverse(i + 1, j, GO_DOWN);
                }
            }
            case 2 -> {
                if (i + 1 <= down) {
                    traverse(i + 1, j, direction);
                } else if (j - 1 >= left) {
                    down--;
                    traverse(i, j - 1, GO_LEFT);
                }
            }
            case 3 -> {
                if (j - 1 >= left) {
                    traverse(i, j - 1, direction);
                } else if (i - 1 >= top) {
                    left++;
                    traverse(i - 1, j, GO_UP);

                }
            }
            default -> {
                if (i - 1 >= top) {
                    traverse(i - 1, j, direction);
                } else if (j + 1 <= right) {
                    top++;
                    traverse(i, j + 1, GO_RIGHT);
                }
            }
        }
    }
}
