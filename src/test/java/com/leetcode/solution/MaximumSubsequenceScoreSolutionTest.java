package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubsequenceScoreSolutionTest {
    private MaximumSubsequenceScoreSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumSubsequenceScoreSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,3,3,2; 2,1,3,4; 3; 12",
            "4,2,3,1,1; 7,5,10,9,6; 1; 30"
    }, delimiter = ';')
    void maxScore(@ConvertWith(IntegerArrayConverter.class) int[] nums1,
                  @ConvertWith(IntegerArrayConverter.class) int[] nums2, int k, long expected) {
        long result = solution.maxScore(nums1, nums2, k);

        assertEquals(expected, result);
    }
}