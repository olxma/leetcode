package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NonDecreasingSubsequencesSolutionTest {
    private static NonDecreasingSubsequencesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new NonDecreasingSubsequencesSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findSubsequences(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.findSubsequences(nums);

        assertEquals(result.size(), expected.size());
        assertTrue(result.containsAll(expected));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{4, 6, 7, 7}, List.of(List.of(4, 6), List.of(4, 6, 7), List.of(4, 6, 7, 7), List.of(4, 7), List.of(4, 7, 7), List.of(6, 7), List.of(6, 7, 7), List.of(7, 7)))
        );
    }
}