package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageSalaryExcludingTheMinimumAndMaximumSalarySolutionTest {
    private AverageSalaryExcludingTheMinimumAndMaximumSalarySolution solution;

    @BeforeEach
    void setUp() {
        solution = new AverageSalaryExcludingTheMinimumAndMaximumSalarySolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4000,3000,1000,2000; 2500.00000",
            "1000,2000,3000; 2000.00000"
    }, delimiter = ';')
    void average(@ConvertWith(IntegerArrayConverter.class) int[] salary, double expected) {
        double result = solution.average(salary);

        assertEquals(expected, result);
    }
}