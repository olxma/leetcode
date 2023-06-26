package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalCostToHireKWorkersSolutionTest {
    private TotalCostToHireKWorkersSolution solution;

    @BeforeEach
    void setUp() {
        solution = new TotalCostToHireKWorkersSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "17,12,10,2,7,2,11,20,8; 3; 4; 11",
            "1,2,4,1; 3; 3; 4",
            "18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75; 13; 23; 223",
            "48; 1; 1; 48",
            "60,87,94,42,12,60; 5; 4; 261"
    }, delimiter = ';')
    void totalCost(@ConvertWith(IntegerArrayConverter.class) int[] costs, int k, int candidates, long expected) {
        long result = solution.totalCost(costs, k, candidates);

        assertEquals(expected, result);
    }
}