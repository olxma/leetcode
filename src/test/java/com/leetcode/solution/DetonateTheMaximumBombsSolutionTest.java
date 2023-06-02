package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetonateTheMaximumBombsSolutionTest {
    private DetonateTheMaximumBombsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DetonateTheMaximumBombsSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 3}, {6, 1, 4}}, 2),
                Arguments.of(new int[][]{{1, 1, 5}, {10, 10, 5}}, 1),
                Arguments.of(new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void maximumDetonation(int[][] bombs, int expected) {
        int result = solution.maximumDetonation(bombs);

        assertEquals(expected, result);
    }
}