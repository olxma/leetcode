package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumScoreOfAPathBetweenTwoCitiesSolutionTest {
    private MinimumScoreOfAPathBetweenTwoCitiesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumScoreOfAPathBetweenTwoCitiesSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}, 5),
                Arguments.of(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}, 2),
                Arguments.of(6, new int[][]{{4, 5, 7468}, {6, 2, 7173}, {6, 3, 8365}, {2, 3, 7674}, {5, 6, 7852}, {1, 2, 8547}, {2, 4, 1885}, {2, 5, 5192}, {1, 3, 4065}, {1, 4, 7357}}, 1885)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void minScore(int n, int[][] roads, int expected) {
        int result = solution.minScore(n, roads);

        assertEquals(expected, result);
    }
}