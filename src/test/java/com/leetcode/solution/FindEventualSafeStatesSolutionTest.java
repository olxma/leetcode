package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindEventualSafeStatesSolutionTest {
    private FindEventualSafeStatesSolution solution;

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}, List.of(2, 4, 5, 6)),
                Arguments.of(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}, List.of(4)));
    }

    @BeforeEach
    void setUp() {
        solution = new FindEventualSafeStatesSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void eventualSafeNodes(int[][] graph, List<Integer> expected) {
        List<Integer> result = solution.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }
}