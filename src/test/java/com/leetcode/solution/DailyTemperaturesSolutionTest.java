package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DailyTemperaturesSolutionTest {
    private DailyTemperaturesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DailyTemperaturesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "73,74,75,71,69,72,76,73; 1,1,4,2,1,1,0,0",
            "30,40,50,60; 1,1,1,0",
            "30,60,90; 1,1,0"
    }, delimiter = ';')
    void dailyTemperatures(@ConvertWith(IntegerArrayConverter.class) int[] temperatures,
                           @ConvertWith(IntegerArrayConverter.class) int[] expected) {
        int[] result = solution.dailyTemperatures(temperatures);

        assertArrayEquals(expected, result);
    }
}