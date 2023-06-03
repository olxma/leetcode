package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeNeededToInformAllEmployeesSolutionTest {
    private TimeNeededToInformAllEmployeesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new TimeNeededToInformAllEmployeesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1; 0; -1; 0; 0",
            "6; 2; 2,2,-1,2,2,2; 0,0,1,0,0,0; 1"
    }, delimiter = ';')
    void numOfMinutes(int n,
                      int headID,
                      @ConvertWith(IntegerArrayConverter.class) int[] manager,
                      @ConvertWith(IntegerArrayConverter.class) int[] informTime,
                      int expected) {
        int result = solution.numOfMinutes(n, headID, manager, informTime);

        assertEquals(expected, result);
    }
}