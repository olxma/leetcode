package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsGraphBipartiteSolutionTest {
    private IsGraphBipartiteSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IsGraphBipartiteSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}, false),
                Arguments.of(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}, true),
                Arguments.of(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}, true),
                Arguments.of(new int[][]{{1}, {0, 3}, {3}, {1, 2}}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isBipartite(int[][] graph, boolean expected) {
        boolean result = solution.isBipartite(graph);

        assertEquals(expected, result);
    }
}