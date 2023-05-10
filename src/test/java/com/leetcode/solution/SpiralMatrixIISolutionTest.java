package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SpiralMatrixIISolutionTest {
    private SpiralMatrixIISolution solution;

    @BeforeEach
    void setUp() {
        solution = new SpiralMatrixIISolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(3, new int[][]{
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5}
                }),
                Arguments.of(1, new int[][]{
                        {1}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void generateMatrix(int n, int[][] expected) {
        int[][] result = solution.generateMatrix(n);

        assertArrayEquals(expected, result);
    }
}