package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakesAndLaddersSolutionTest {
    private static SnakesAndLaddersSolution solution;

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 35, -1, -1, 13, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 15, -1, -1, -1, -1}
                }, 4),
                Arguments.of(new int[][]{
                        {-1, -1},
                        {-1, 3}
                }, 1)
        );
    }

    @BeforeEach
    void setUp() {
        solution = new SnakesAndLaddersSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void snakesAndLadders(int[][] board, int expected) {
        int result = solution.snakesAndLadders(board);

        assertEquals(expected, result);
    }
}