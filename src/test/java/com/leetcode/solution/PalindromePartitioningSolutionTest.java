package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromePartitioningSolutionTest {
    private static PalindromePartitioningSolution solution;

    @BeforeEach
    void setUp() {
        solution = new PalindromePartitioningSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void partition(String s, List<List<String>> expected) {
        List<List<String>> result = solution.partition(s);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("aab", List.of(List.of("a", "a", "b"), List.of("aa", "b"))),
                Arguments.of("a", List.of(List.of("a")))
        );
    }
}