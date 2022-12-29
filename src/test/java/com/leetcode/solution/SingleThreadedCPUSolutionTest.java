package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SingleThreadedCPUSolutionTest {
    private SingleThreadedCPUSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SingleThreadedCPUSolution();
    }

    @Test
    void getOrder() {
        int[][] tasks1 = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] expected1 = new int[]{0, 2, 3, 1};
        int[] result1 = solution.getOrder(tasks1);
        assertArrayEquals(expected1, result1);

        int[][] tasks2 = new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        int[] expected2 = new int[]{4, 3, 2, 0, 1};
        int[] result2 = solution.getOrder(tasks2);
        assertArrayEquals(expected2, result2);

        int[][] tasks3 = new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
        int[] expected3 = new int[]{6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7};
        int[] result3 = solution.getOrder(tasks3);
        assertArrayEquals(expected3, result3);
    }
}