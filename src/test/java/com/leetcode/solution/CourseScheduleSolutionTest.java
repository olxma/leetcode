package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseScheduleSolutionTest {
    private CourseScheduleSolution solution;

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 0}}, true),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false),
                Arguments.of(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}, true),
                Arguments.of(7, new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}, true)
        );
    }

    @BeforeEach
    void setUp() {
        solution = new CourseScheduleSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void canFinish(int numOfCourses, int[][] prerequisites, boolean expected) {
        boolean result = solution.canFinish(numOfCourses, prerequisites);

        assertEquals(expected, result);
    }
}