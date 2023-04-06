package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfClosedIslandsSolutionTest {
    private NumberOfClosedIslandsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfClosedIslandsSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 0, 0, 0, 0, 1, 1, 0},
                                {1, 0, 1, 0, 1, 1, 1, 0},
                                {1, 0, 0, 0, 0, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 0}},
                        2),
                Arguments.of(
                        new int[][]{
                                {0, 0, 1, 0, 0},
                                {0, 1, 0, 1, 0},
                                {0, 1, 1, 1, 0}},
                        1),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 0, 0, 1},
                                {1, 0, 1, 1, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1, 0, 1},
                                {1, 0, 0, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1}},
                        2));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void closedIsland(int[][] grid, int expected) {
        int result = solution.closedIsland(grid);

        assertEquals(expected, result);
    }
}