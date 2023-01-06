package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumIceCreamBarsSolutionTest {
    private MaximumIceCreamBarsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumIceCreamBarsSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,3,2,4,1;    7;  4",
            "10,6,8,7,7,8; 5;  0",
            "1,6,3,1,2,5;  20; 6"
    }, delimiter = ';')
    void maxIceCream1(@ConvertWith(IntegerArrayConverter.class) int[] costs, int coins, int expected) {
        int result = solution.maxIceCream1(costs, coins);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,3,2,4,1;    7;  4",
            "10,6,8,7,7,8; 5;  0",
            "1,6,3,1,2,5;  20; 6"
    }, delimiter = ';')
    void maxIceCream2(@ConvertWith(IntegerArrayConverter.class) int[] costs, int coins, int expected) {
        int result = solution.maxIceCream2(costs, coins);

        assertEquals(expected, result);
    }
}