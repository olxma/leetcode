package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimizeMaximumOfArraySolutionTest {
    private MinimizeMaximumOfArraySolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimizeMaximumOfArraySolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,7,1,6; 5",
            "10,1; 10",
            "13,13,20,0,8,9,9; 16",
            "6,9,3,8,14; 8"
    }, delimiter = ';')
    void minimizeArrayValue(@ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        int result = solution.minimizeArrayValue(nums);

        assertEquals(expected, result);
    }
}