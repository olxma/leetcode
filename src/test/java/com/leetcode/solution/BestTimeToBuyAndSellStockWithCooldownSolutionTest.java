package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockWithCooldownSolutionTest {
    private BestTimeToBuyAndSellStockWithCooldownSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BestTimeToBuyAndSellStockWithCooldownSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,0,2; 3",
            "1; 0",
            "1,2,3,4,5,6,7; 6"
    }, delimiter = ';')
    void maxProfit(@ConvertWith(IntegerArrayConverter.class) int[] prices, int expected) {
        int result = solution.maxProfit(prices);

        assertEquals(expected, result);
    }
}