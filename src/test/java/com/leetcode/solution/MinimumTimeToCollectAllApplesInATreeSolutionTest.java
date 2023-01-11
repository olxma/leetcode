package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumTimeToCollectAllApplesInATreeSolutionTest {
    private static MinimumTimeToCollectAllApplesInATreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumTimeToCollectAllApplesInATreeSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void minTime(int n, int[][] edges, List<Boolean> hasApple, int expected) {
        int result = solution.minTime(n, edges, hasApple);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        int n1 = 7;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple1 = List.of(false, false, true, false, true, true, false);
        int expected1 = 8;

        int n2 = 7;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple2 = List.of(false, false, true, false, false, true, false);
        int expected2 = 6;

        int n3 = 7;
        int[][] edges3 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple3 = List.of(false, false, false, false, false, false, false);
        int expected3 = 0;

        int n4 = 8;
        int[][] edges4 = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {2, 5}, {2, 6}, {4, 7}};
        List<Boolean> hasApple4 = List.of(true, true, false, true, false, true, true, false);
        int expected4 = 10;

        int n5 = 4;
        int[][] edges5 = {{0, 2}, {0, 3}, {1, 2}};
        List<Boolean> hasApple5 = List.of(false, true, false, false);
        int expected5 = 4;

        return Stream.of(
                Arguments.of(n1, edges1, hasApple1, expected1),
                Arguments.of(n2, edges2, hasApple2, expected2),
                Arguments.of(n3, edges3, hasApple3, expected3),
                Arguments.of(n4, edges4, hasApple4, expected4),
                Arguments.of(n5, edges5, hasApple5, expected5));
    }
}