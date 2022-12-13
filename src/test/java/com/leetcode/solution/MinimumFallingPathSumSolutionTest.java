package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumFallingPathSumSolutionTest {
    private MinimumFallingPathSumSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumFallingPathSumSolution();
    }

    @Test
    void minFallingPathSum() {
        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int result = solution.minFallingPathSum(matrix);
        assertEquals(13, result);

        matrix = new int[][]{{-19, 57}, {-40, -5}};
        result = solution.minFallingPathSum(matrix);
        assertEquals(-59, result);

        matrix = new int[][]{{17, 82}, {1, -44}};
        result = solution.minFallingPathSum(matrix);
        assertEquals(-27, result);
    }
}