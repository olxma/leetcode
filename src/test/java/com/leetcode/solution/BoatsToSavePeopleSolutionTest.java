package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoatsToSavePeopleSolutionTest {
    private BoatsToSavePeopleSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BoatsToSavePeopleSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2; 3; 1",
            "3,2,2,1; 3; 3",
            "3,5,3,4; 5; 4",
            "3,2,3,2,2; 6; 3"
    }, delimiter = ';')
    void numRescueBoats(@ConvertWith(IntegerArrayConverter.class) int[] people, int limit, int expected) {
        int result = solution.numRescueBoats(people, limit);

        assertEquals(expected, result);
    }
}