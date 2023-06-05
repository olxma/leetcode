package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfItIsAStraightLineSolutionTest {
    private CheckIfItIsAStraightLineSolution solution;


    @BeforeEach
    void setUp() {
        solution = new CheckIfItIsAStraightLineSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}, true),
                Arguments.of(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void checkStraightLine(int[][] coordinates, boolean expected) {
        boolean result = solution.checkStraightLine(coordinates);

        assertEquals(expected, result);
    }
}