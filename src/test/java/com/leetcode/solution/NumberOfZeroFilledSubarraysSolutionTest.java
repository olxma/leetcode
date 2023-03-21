package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfZeroFilledSubarraysSolutionTest {
    private NumberOfZeroFilledSubarraysSolution solution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfZeroFilledSubarraysSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,3,0,0,2,0,0,4;   6",
            "0,0,0,2,0,0;       9"
    }, delimiter = ';')
    void zeroFilledSubarray(@ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        long result = solution.zeroFilledSubarray(nums);

        assertEquals(expected, result);
    }
}