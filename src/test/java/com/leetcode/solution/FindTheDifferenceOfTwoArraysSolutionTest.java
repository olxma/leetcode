package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheDifferenceOfTwoArraysSolutionTest {
    private FindTheDifferenceOfTwoArraysSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindTheDifferenceOfTwoArraysSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4, 6}, List.of(List.of(1, 3), List.of(4, 6))),
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}, List.of(List.of(3), List.of()))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findDifference(int[] nums1, int[] nums2, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.findDifference(nums1, nums2);

        assertEquals(expected, result);
    }
}