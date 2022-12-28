package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveStonesToMinimizeTheTotalSolutionTest {
    private RemoveStonesToMinimizeTheTotalSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RemoveStonesToMinimizeTheTotalSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,4,9;   2; 12",
            "4,3,6,7; 3; 12"
    }, delimiter = ';')
    void minStoneSum(@ConvertWith(IntegerArrayConverter.class) int[] piles, int k, int expected) {
        int result = solution.minStoneSum(piles, k);

        assertEquals(expected, result);
    }
}