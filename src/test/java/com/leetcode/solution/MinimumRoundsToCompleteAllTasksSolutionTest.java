package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRoundsToCompleteAllTasksSolutionTest {
    private MinimumRoundsToCompleteAllTasksSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumRoundsToCompleteAllTasksSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,2,3,3,2,4,4,4,4,4; 4",
            "2,3,3; -1",
            "69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69; 20"
    }, delimiter = ';')
    void minimumRounds(@ConvertWith(IntegerArrayConverter.class) int[] tasks, int expected) {
        int result = solution.minimumRounds(tasks);

        assertEquals(expected, result);
    }
}