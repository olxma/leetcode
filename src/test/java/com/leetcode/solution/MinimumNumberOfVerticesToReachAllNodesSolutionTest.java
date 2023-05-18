package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MinimumNumberOfVerticesToReachAllNodesSolutionTest {
    private MinimumNumberOfVerticesToReachAllNodesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumNumberOfVerticesToReachAllNodesSolution();
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(6,
                        List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2)),
                        List.of(0, 3)),
                Arguments.of(5,
                        List.of(List.of(0, 1), List.of(2, 1), List.of(3, 1), List.of(1, 4), List.of(2, 4)),
                        List.of(0, 2, 3)),
                Arguments.of(3,
                        List.of(List.of(1, 2), List.of(1, 0), List.of(0, 2)),
                        List.of(1)),
                Arguments.of(5,
                        List.of(List.of(1, 2), List.of(3, 2), List.of(4, 1), List.of(3, 4), List.of(0, 2)),
                        List.of(0, 3)));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findSmallestSetOfVertices(int n, List<List<Integer>> edges, List<Integer> expected) {
        List<Integer> result = solution.findSmallestSetOfVertices(n, edges);
        System.out.println(expected + " | " + result);
        assertTrue(result.containsAll(expected));
    }
}