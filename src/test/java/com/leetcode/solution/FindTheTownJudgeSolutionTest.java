package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheTownJudgeSolutionTest {
    private static FindTheTownJudgeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindTheTownJudgeSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findJudge(int n, int[][] trust, int expected) {
        int result = solution.findJudge(n, trust);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 2}}, 2),
                Arguments.of(3, new int[][]{{1, 3}, {2, 3}}, 3),
                Arguments.of(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}, -1)
        );
    }
}