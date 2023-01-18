package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumCircularSubarraySolutionTest {
    private static MaximumSumCircularSubarraySolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumSumCircularSubarraySolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,-2,3,-2; 3",
            "5,-3,5;    10",
            "-3,-2,-3;  -2"
    }, delimiter = ';')
    void maxSubarraySumCircular(@ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        int result = solution.maxSubarraySumCircular(nums);

        assertEquals(expected, result);
    }
}