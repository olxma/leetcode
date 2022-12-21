package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PossibleBipartitionSolutionTest {
    private PossibleBipartitionSolution solution;

    @BeforeEach
    void setUp() {
        solution = new PossibleBipartitionSolution();
    }

    @Test
    void possibleBipartition() {
        int n1 = 4;
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(solution.possibleBipartition(n1, dislikes1));

        int n2 = 3;
        int[][] dislikes2 = {{1, 2}, {1, 3}, {2, 3}};
        assertFalse(solution.possibleBipartition(n2, dislikes2));

        int n3 = 5;
        int[][] dislikes3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(solution.possibleBipartition(n3, dislikes3));

        int n4 = 5;
        int[][] dislikes4 = {{1, 2}, {1, 3}, {1, 4}, {1, 5}};
        assertTrue(solution.possibleBipartition(n4, dislikes4));

        int n5 = 1;
        int[][] dislike5 = {};
        assertTrue(solution.possibleBipartition(n5, dislike5));

        int n6 = 10;
        int[][] dislike6 = {{4, 7}, {4, 8}, {5, 6}, {1, 6}, {3, 7}, {2, 5}, {5, 8}, {1, 2}, {4, 9}, {6, 10}, {8, 10}, {3, 6}, {2, 10}, {9, 10}, {3, 9}, {2, 3}, {1, 9}, {4, 6}, {5, 7}, {3, 8}, {1, 8}, {1, 7}, {2, 4}};
        assertTrue(solution.possibleBipartition(n6, dislike6));
    }
}