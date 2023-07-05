package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubarrayOf1sAfterDeletingOneElementSolutionTest {
    private LongestSubarrayOf1sAfterDeletingOneElementSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LongestSubarrayOf1sAfterDeletingOneElementSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1,0,1; 3",
            "0,1,1,1,0,1,1,0,1; 5",
            "1,1,1; 2"
    }, delimiter = ';')
    void longestSubarray(@ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        int result = solution.longestSubarray(nums);

        assertEquals(expected, result);
    }
}