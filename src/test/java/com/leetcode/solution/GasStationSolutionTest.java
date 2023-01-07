package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GasStationSolutionTest {
    private GasStationSolution solution;

    @BeforeEach
    void setUp() {
        solution = new GasStationSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5; 3,4,5,1,2;  3",
            "2,3,4;     3,4,3;     -1",
            "5,1,2,3,4; 4,4,1,5,1;  4",
            "5,8,2,8;   6,5,6,6;    3"
    }, delimiter = ';')
    void canCompleteCircuit(@ConvertWith(IntegerArrayConverter.class) int[] gas,
                            @ConvertWith(IntegerArrayConverter.class) int[] cost,
                            int expected) {
        int result = solution.canCompleteCircuit(gas, cost);

        assertEquals(expected, result);
    }
}