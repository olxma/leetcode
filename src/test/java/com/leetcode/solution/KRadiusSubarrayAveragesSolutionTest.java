package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KRadiusSubarrayAveragesSolutionTest {
    private KRadiusSubarrayAveragesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new KRadiusSubarrayAveragesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "7,4,3,9,1,8,5,2,6; 3; -1,-1,-1,5,4,4,-1,-1,-1",
            "100000; 0; 100000",
            "8; 100000; -1"
    }, delimiter = ';')
    void getAverages(@ConvertWith(IntegerArrayConverter.class) int[] nums, int k,
                     @ConvertWith(IntegerArrayConverter.class) int[] expected) {
        int[] result = solution.getAverages(nums, k);

        assertArrayEquals(expected, result);
    }
}