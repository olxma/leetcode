package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UncrossedLinesSolutionTest {
    private UncrossedLinesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new UncrossedLinesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,4,2; 1,2,4; 2",
            "2,5,1,2,5; 10,5,2,1,5,2; 3",
            "1,3,7,1,7,5; 1,9,2,5,1; 2"
    }, delimiter = ';')
    void maxUncrossedLines(@ConvertWith(IntegerArrayConverter.class) int[] nums1,
                           @ConvertWith(IntegerArrayConverter.class) int[] nums2,
                           int expected) {
        int result = solution.maxUncrossedLines(nums1, nums2);

        assertEquals(expected, result);
    }
}