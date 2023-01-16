package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertIntervalSolutionTest {
    private static InsertIntervalSolution solution;

    @BeforeEach
    void setUp() {
        solution = new InsertIntervalSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void insert(int[][] intervals, int[] newInterval, int[][] expected) {
        int[][] result = solution.insert(intervals, newInterval);

        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        int[][] intervals1 = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval1 = new int[]{2, 5};
        int[][] expected1 = new int[][]{{1, 5}, {6, 9}};

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = new int[]{4, 8};
        int[][] expected2 = new int[][]{{1, 2}, {3, 10}, {12, 16}};

        int[][] intervals3 = new int[][]{{1, 2}, {5, 6}};
        int[] newInterval3 = new int[]{3, 4};
        int[][] expected3 = new int[][]{{1, 2}, {3, 4}, {5, 6}};

        int[][] intervals4 = new int[][]{{1, 5}};
        int[] newInterval4 = new int[]{2, 3};
        int[][] expected4 = new int[][]{{1, 5}};

        int[][] intervals5 = new int[][]{{1, 5}};
        int[] newInterval5 = new int[]{0, 3};
        int[][] expected5 = new int[][]{{0, 5}};

        int[][] intervals6 = new int[][]{{1, 5}};
        int[] newInterval6 = new int[]{0, 6};
        int[][] expected6 = new int[][]{{0, 6}};

        return Stream.of(
                Arguments.of(intervals1, newInterval1, expected1),
                Arguments.of(intervals2, newInterval2, expected2),
                Arguments.of(intervals3, newInterval3, expected3),
                Arguments.of(intervals4, newInterval4, expected4),
                Arguments.of(intervals5, newInterval5, expected5),
                Arguments.of(intervals6, newInterval6, expected6)
        );
    }
}