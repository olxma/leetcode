package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateStackSequencesSolutionTest {
    private ValidateStackSequencesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ValidateStackSequencesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5; 4,5,3,2,1; true",
            "1,2,3,4,5; 4,3,5,1,2; false",
            "1,0; 1,0; true",
            "0,2,1; 0,1,2; true"
    }, delimiter = ';')
    void validateStackSequences(@ConvertWith(IntegerArrayConverter.class) int[] pushed,
                                @ConvertWith(IntegerArrayConverter.class) int[] popped,
                                boolean expected) {
        boolean result = solution.validateStackSequences(pushed, popped);

        assertEquals(expected, result);
    }
}