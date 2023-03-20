package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanPlaceFlowersSolutionTest {
    private CanPlaceFlowersSolution solution;

    @BeforeEach
    void setUp() {
        solution = new CanPlaceFlowersSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0,0,0,1; 1; true",
            "1,0,0,0,1; 2; false"
    }, delimiter = ';')
    void canPlaceFlowers(@ConvertWith(IntegerArrayConverter.class) int[] flowerbed, int n, boolean expected) {
        boolean result = solution.canPlaceFlowers(flowerbed, n);

        assertEquals(expected, result);
    }
}