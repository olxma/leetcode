package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSmallestLetterGreaterThanTargetSolutionTest {
    private FindSmallestLetterGreaterThanTargetSolution solution;

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new char[]{'c', 'f', 'j'}, 'a', 'c'),
                Arguments.of(new char[]{'c', 'f', 'j'}, 'c', 'f'),
                Arguments.of(new char[]{'x', 'x', 'y', 'y'}, 'z', 'x')
        );
    }

    @BeforeEach
    void setUp() {
        solution = new FindSmallestLetterGreaterThanTargetSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void nextGreatestLetter(char[] letters, char target, char expected) {
        char result = solution.nextGreatestLetter(letters, target);

        assertEquals(expected, result);
    }
}