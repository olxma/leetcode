package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightSolutionTest {
    private LastStoneWeightSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LastStoneWeightSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,7,4,1,8,1; 1",
            "1; 1"
    }, delimiter = ';')
    void lastStoneWeight(@ConvertWith(IntegerArrayConverter.class) int[] stones, int expected) {
        int result = solution.lastStoneWeight(stones);

        assertEquals(expected, result);
    }
}