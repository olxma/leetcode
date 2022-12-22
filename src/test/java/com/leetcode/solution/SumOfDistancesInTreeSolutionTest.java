package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SumOfDistancesInTreeSolutionTest {
    private SumOfDistancesInTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SumOfDistancesInTreeSolution();
    }

    @Test
    void sumOfDistancesInTree() {
        int n1 = 6;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] result1 = solution.sumOfDistancesInTree(n1, edges1);
        int[] expected1 = {8, 12, 6, 10, 10, 10};
        assertArrayEquals(expected1, result1);

        int n2 = 1;
        int[][] edges2 = {};
        int[] result2 = solution.sumOfDistancesInTree(n2, edges2);
        int[] expected2 = {0};
        assertArrayEquals(expected2, result2);

        int n3 = 2;
        int[][] edges3 = {{1, 0}};
        int[] result3 = solution.sumOfDistancesInTree(n3, edges3);
        int[] expected3 = {1, 1};
        assertArrayEquals(expected3, result3);
    }
}