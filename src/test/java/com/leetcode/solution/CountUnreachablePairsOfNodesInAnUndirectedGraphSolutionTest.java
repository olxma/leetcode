package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountUnreachablePairsOfNodesInAnUndirectedGraphSolutionTest {
    private CountUnreachablePairsOfNodesInAnUndirectedGraphSolution solution;

    @BeforeEach
    void setUp() {
        solution = new CountUnreachablePairsOfNodesInAnUndirectedGraphSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}, 0),
                Arguments.of(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}, 14)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void countPairs(int n, int[][] edges, int expected) {
        long result = solution.countPairs(n, edges);

        assertEquals(expected, result);
    }
}