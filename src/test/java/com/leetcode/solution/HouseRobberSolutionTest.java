package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseRobberSolutionTest {
    private HouseRobberSolution solution;

    @BeforeEach
    void setUp() {
        solution = new HouseRobberSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,1; 4",
            "2,7,9,3,1; 12",
            "1,2,3,1,33,11,100,100,2; 139",
            "100,1,1,100; 200",
            "100,1,1,100,200,200; 400"
    }, delimiter = ';')
    void rob(@ConvertWith(IntegerArrayConverter.class) int[] nums, int expected) {
        int result = solution.rob(nums);

        assertEquals(expected, result);
    }
}