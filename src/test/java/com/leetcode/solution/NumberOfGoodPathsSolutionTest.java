package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfGoodPathsSolutionTest {
    private static NumberOfGoodPathsSolution solution;
    private static NumberOfGoodPathsSolutionOfficial officialSolution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfGoodPathsSolution();
        officialSolution = new NumberOfGoodPathsSolutionOfficial();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void numberOfGoodPaths(int[] vals, int[][] edges, int expected) {
        int result = solution.numberOfGoodPaths(vals, edges);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void numberOfGoodPathsOfficial(int[] vals, int[][] edges, int expected) {
        int result = officialSolution.numberOfGoodPaths(vals, edges);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        int[] vals1 = {1, 3, 2, 1, 3};
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int expected1 = 6;

        int[] vals2 = {1, 1, 2, 2, 3};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {2, 4}};
        int expected2 = 7;

        int[] vals3 = {1};
        int[][] edges3 = {};
        int expected3 = 1;

        return Stream.of(
                Arguments.of(vals1, edges1, expected1),
                Arguments.of(vals2, edges2, expected2),
                Arguments.of(vals3, edges3, expected3));
    }
}