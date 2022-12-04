package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAverageDifferenceSolutionTest {
    private static MinimumAverageDifferenceSolution solution;

    @BeforeAll
    public static void init() {
        solution = new MinimumAverageDifferenceSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,5,3,9,5,3; 3",
            "0; 0",
            "1,2,3,4,5,6,7,8,9; 0",
            "22,33,44,11,66,44,77; 2",
            "1779,7087,98,7861,2042,5260,958,5248,4209,3314; 4"
    }, delimiter = ';')
    void minimumAverageDifference(@ConvertWith(IntegerArrayConverter.class) int[] input, int expected) {
        int result = solution.minimumAverageDifference(input);

        assertEquals(expected, result);
    }
}