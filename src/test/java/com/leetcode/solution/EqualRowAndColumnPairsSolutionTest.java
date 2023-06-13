package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualRowAndColumnPairsSolutionTest {
    private EqualRowAndColumnPairsSolution solution;

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
                Arguments.of(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3)
        );
    }

    @BeforeEach
    void setUp() {
        solution = new EqualRowAndColumnPairsSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void equalPairs(int[][] grid, int expected) {
        int result = solution.equalPairs(grid);

        assertEquals(expected, result);
    }
}