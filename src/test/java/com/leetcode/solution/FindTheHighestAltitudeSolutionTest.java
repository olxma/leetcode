package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheHighestAltitudeSolutionTest {
    private FindTheHighestAltitudeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindTheHighestAltitudeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-5,1,5,0,-7; 1",
            "-4,-3,-2,-1,4,3,2; 0"
    }, delimiter = ';')
    void largestAltitude(@ConvertWith(IntegerArrayConverter.class) int[] gain, int expected) {
        int result = solution.largestAltitude(gain);

        assertEquals(expected, result);
    }
}