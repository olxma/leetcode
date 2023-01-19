package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySumsDivisibleByKSolutionTest {
    private static SubarraySumsDivisibleByKSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SubarraySumsDivisibleByKSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4,5,0,-2,-3,1; 5; 7",
            "5;             9; 0"
    }, delimiter = ';')
    void subarraysDivByK(@ConvertWith(IntegerArrayConverter.class) int[] nums, int k, int expected) {
        int result = solution.subarraysDivByK(nums, k);

        assertEquals(expected, result);
    }
}