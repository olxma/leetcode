package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumBagsWithFullCapacityOfRocksSolutionTest {
    private MaximumBagsWithFullCapacityOfRocksSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumBagsWithFullCapacityOfRocksSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,3,4,5; 1,2,4,4; 2;   3",
            "10,2,2;  2,2,0;   100; 3"
    }, delimiter = ';')
    void maximumBags(@ConvertWith(IntegerArrayConverter.class) int[] capacity,
                     @ConvertWith(IntegerArrayConverter.class) int[] rocks,
                     int additionalRocks, int expected) {

        int result = solution.maximumBags(capacity, rocks, additionalRocks);

        assertEquals(expected, result);
    }
}