package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindIfPathExistsInGraphSolutionTest {
    private FindIfPathExistsInGraphSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindIfPathExistsInGraphSolution();
    }

    @Test
    void validPath() {
        int source = 0;

        // Example 1:
        int n = 3;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        int destination = 2;

        boolean result = solution.validPath(n, edges, source, destination);

        assertTrue(result);

        // Example 2:
        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        destination = 5;

        result = solution.validPath(n, edges, source, destination);

        assertFalse(result);
    }
}