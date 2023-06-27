package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKPairsWithSmallestSumsSolutionTest {
    private FindKPairsWithSmallestSumsSolution solution;

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3,
                        List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6))),
                Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2,
                        List.of(List.of(1, 1), List.of(1, 1))),
                Arguments.of(new int[]{1, 2}, new int[]{3}, 3,
                        List.of(List.of(1, 3), List.of(2, 3)))
        );
    }

    @BeforeEach
    void setUp() {
        solution = new FindKPairsWithSmallestSumsSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void kSmallestPairs(int[] nums1, int[] nums2, int k, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);

        assertEquals(expected, result);
    }
}