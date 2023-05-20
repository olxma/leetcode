package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EvaluateDivisionSolutionTest {
    private EvaluateDivisionSolution solution;

    @BeforeEach
    void setUp() {
        solution = new EvaluateDivisionSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        List.of(List.of("a", "b"), List.of("b", "c")),
                        new double[]{2.0, 3.0},
                        List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")),
                        new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000}),
                Arguments.of(
                        List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd")),
                        new double[]{1.5, 2.5, 5.0},
                        List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc")),
                        new double[]{3.75000, 0.40000, 5.00000, 0.20000}),
                Arguments.of(
                        List.of(List.of("a", "b")),
                        new double[]{0.5},
                        List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y")),
                        new double[]{0.50000, 2.00000, -1.00000, -1.00000}
                ));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries, double[] expected) {
        double[] result = solution.calcEquation(equations, values, queries);

        assertArrayEquals(expected, result);
    }
}