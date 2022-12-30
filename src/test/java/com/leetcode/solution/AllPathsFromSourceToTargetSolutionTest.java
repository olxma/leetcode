package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllPathsFromSourceToTargetSolutionTest {
    private AllPathsFromSourceToTargetSolution solution;

    @BeforeEach
    void setUp() {
        solution = new AllPathsFromSourceToTargetSolution();
    }

    @Test
    void allPathsSourceTarget() {
        int[][] graph1 = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> result1 = solution.allPathsSourceTarget(graph1);
        List<List<Integer>> expected1 = List.of(List.of(0, 1, 3), List.of(0, 2, 3));
        assertEquals(expected1, result1);

        int[][] graph2 = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> result2 = solution.allPathsSourceTarget(graph2);
        List<List<Integer>> expected2 =
                List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4));
        assertEquals(expected2, result2);
    }
}