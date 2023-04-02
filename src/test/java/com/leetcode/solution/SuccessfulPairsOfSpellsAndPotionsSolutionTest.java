package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SuccessfulPairsOfSpellsAndPotionsSolutionTest {
    private SuccessfulPairsOfSpellsAndPotionsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SuccessfulPairsOfSpellsAndPotionsSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,1,3; 1,2,3,4,5;  7;  4,0,3",
            "3,1,2; 8,5,8;      16; 2,0,2"
    }, delimiter = ';')
    void successfulPairs(@ConvertWith(IntegerArrayConverter.class) int[] spells,
                         @ConvertWith(IntegerArrayConverter.class) int[] potions,
                         int success,
                         @ConvertWith(IntegerArrayConverter.class) int[] expected) {
        int[] result = solution.successfulPairs(spells, potions, success);

        assertArrayEquals(expected, result);
    }
}