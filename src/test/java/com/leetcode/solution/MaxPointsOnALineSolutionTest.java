package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPointsOnALineSolutionTest {
    private MaxPointsOnALineSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaxPointsOnALineSolution();
    }

    @Test
    void maxPoints() {
        int[][] points1 = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int result1 = solution.maxPoints(points1);
        assertEquals(3, result1);

        int[][] points2 = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int result2 = solution.maxPoints(points2);
        assertEquals(4, result2);
    }
}