package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfOperationsToMakeNetworkConnectedSolutionTest {
    private NumberOfOperationsToMakeNetworkConnectedSolution solution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfOperationsToMakeNetworkConnectedSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}, 1),
                Arguments.of(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}, 2),
                Arguments.of(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}, -1),
                Arguments.of(11, new int[][]{{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void makeConnected(int n, int[][] connections, int expected) {
        int result = solution.makeConnected(n, connections);

        assertEquals(expected, result);
    }
}