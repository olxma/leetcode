package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignOfTheProductOfAnArraySolutionTest {
    private SignOfTheProductOfAnArraySolution solution;

    @BeforeEach
    void setUp() {
        solution = new SignOfTheProductOfAnArraySolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,-2,-3,-4,3,2,1; 1",
            "1,5,0,2,-3; 0",
            "-1,1,-1,1,-1; -1"
    }, delimiter = ';')
    void arraySign(@ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        int result = solution.arraySign(nums);

        assertEquals(expected, result);
    }
}