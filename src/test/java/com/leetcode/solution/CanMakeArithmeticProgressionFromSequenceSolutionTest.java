package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanMakeArithmeticProgressionFromSequenceSolutionTest {
    private CanMakeArithmeticProgressionFromSequenceSolution solution;

    @BeforeEach
    void setUp() {
        solution = new CanMakeArithmeticProgressionFromSequenceSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,5,1; true",
            "1,2,4; false"
    }, delimiter = ';')
    void canMakeArithmeticProgression(@ConvertWith(IntegerArrayConverter.class) int[] arr, boolean expected) {
        boolean result = solution.canMakeArithmeticProgression(arr);

        assertEquals(expected, result);
    }
}