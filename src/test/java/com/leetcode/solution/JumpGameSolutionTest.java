package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameSolutionTest {
    private JumpGameSolution solution;

    @BeforeEach
    void setUp() {
        solution = new JumpGameSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,3,1,1,4; true",
            "3,2,1,0,4; false",
            "1; true",
            "2,0; true",
            "2,0,2; true",
            "1,1,1,0; true",
            "1,2,0,1; true",
            "2,1,2,2,1,2,2,2; true",
            "4,1,0,2,2,4,4,4,1,2; true",
            "8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5; true",
            "0,2,3; false"
    }, delimiter = ';')
    void canJump(@ConvertWith(IntegerArrayConverter.class) int[] nums, boolean expected) {
        boolean result = solution.canJump(nums);

        assertEquals(expected, result);
    }
}