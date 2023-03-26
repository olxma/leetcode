package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCycleInAGraphSolutionTest {
    private LongestCycleInAGraphSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LongestCycleInAGraphSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,3,4,2,3;      3",
            "2,-1,3,1;      -1",
            "-1,4,-1,2,0,4; -1"
    }, delimiter = ';')
    void longestCycle(@ConvertWith(IntegerArrayConverter.class) int[] edges, int expected) {
        int result = solution.longestCycle(edges);

        assertEquals(expected, result);
    }
}