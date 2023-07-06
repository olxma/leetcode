package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSizeSubarraySumSolutionTest {
    private MinimumSizeSubarraySumSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumSizeSubarraySumSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "7; 2,3,1,2,4,3; 2",
            "4; 1,4,4; 1",
            "11; 1,1,1,1,1,1,1,1; 0"
    }, delimiter = ';')
    void minSubArrayLen(int target, @ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        int result = solution.minSubArrayLen(target, nums);

        assertEquals(expected, result);
    }
}