package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfArrowsToBurstBalloonsSolutionTest {
    private MinimumNumberOfArrowsToBurstBalloonsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumNumberOfArrowsToBurstBalloonsSolution();
    }

    @Test
    void findMinArrowShots() {
        int[][] points1 = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int expected1 = 2;
        int result1 = solution.findMinArrowShots(points1);
        assertEquals(expected1, result1);

        int[][] points2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int expected2 = 2;
        int result2 = solution.findMinArrowShots(points2);
        assertEquals(expected2, result2);

        int[][] points3 = new int[][]{{-2147483648, 2147483647}};
        int expected3 = 1;
        int result3 = solution.findMinArrowShots(points3);
        assertEquals(expected3, result3);

        int[][] points4 = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int expected4 = 2;
        int result4 = solution.findMinArrowShots(points4);
        assertEquals(expected4, result4);
    }
}