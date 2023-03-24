package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorderRoutesToMakeAllPathsLeadToTheCityZeroSolutionTest {
    private ReorderRoutesToMakeAllPathsLeadToTheCityZeroSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ReorderRoutesToMakeAllPathsLeadToTheCityZeroSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}, 3),
                Arguments.of(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}, 2),
                Arguments.of(3, new int[][]{{1, 0}, {2, 0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void minReorder(int n, int[][] connections, int expected) {
        int result = solution.minReorder(n, connections);

        assertEquals(expected, result);
    }
}