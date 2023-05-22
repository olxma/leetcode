package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequentElementsSolutionTest {
    private TopKFrequentElementsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new TopKFrequentElementsSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1,1,2,2,3; 2; 1,2",
            "1; 1; 1"
    }, delimiter = ';')
    void topKFrequent(@ConvertWith(IntegerArrayConverter.class) int[] nums, int k,
                      @ConvertWith(IntegerArrayConverter.class) int[] expected) {
        int[] result = solution.topKFrequent(nums, k);

        assertArrayEquals(expected, result);
    }
}