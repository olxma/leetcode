package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsIIISolutionTest {
    private UniquePathsIIISolution solution;

    @BeforeEach
    void setUp() {
        solution = new UniquePathsIIISolution();
    }

    @Test
    void uniquePathsIII() {
        int[][] grid1 = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int expected1 = 2;
        int result1 = solution.uniquePathsIII(grid1);
        assertEquals(expected1, result1);

        int[][] grid2 = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int expected2 = 4;
        int result2 = solution.uniquePathsIII(grid2);
        assertEquals(expected2, result2);

        int[][] grid3 = new int[][]{{0, 1}, {2, 0}};
        int expected3 = 0;
        int result3 = solution.uniquePathsIII(grid3);
        assertEquals(expected3, result3);
    }
}