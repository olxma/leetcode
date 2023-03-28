package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCostForTicketsSolutionTest {
    private MinimumCostForTicketsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumCostForTicketsSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,4,6,7,8,20;                  2,7,15;     11",
            "1,2,3,4,5,6,7,8,9,10,30,31;    2,7,15;     17",
            "1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28; 3,13,45; 44",
            "1,4,6,7,8,20; 7,2,15; 6",
            "1,5,8,9,10,12,13,16,17,18,19,20,23,24,29; 3,12,54; 39"
    }, delimiter = ';')
    void mincostTickets(@ConvertWith(IntegerArrayConverter.class) int[] days,
                        @ConvertWith(IntegerArrayConverter.class) int[] costs,
                        int expected) {
        int result = solution.mincostTickets(days, costs);

        assertEquals(expected, result);
    }
}