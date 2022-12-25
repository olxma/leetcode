package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LongestSubsequenceWithLimitedSumSolutionTest {
    private LongestSubsequenceWithLimitedSumSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LongestSubsequenceWithLimitedSumSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4,5,2,1; 3,10,21; 2,3,4",
            "2,3,4,5; 1; 0"
    }, delimiter = ';')
    void answerQueries(@ConvertWith(IntegerArrayConverter.class) int[] nums,
                       @ConvertWith(IntegerArrayConverter.class) int[] queries,
                       @ConvertWith(IntegerArrayConverter.class) int[] expected) {
        int[] result = solution.answerQueries(nums, queries);

        assertArrayEquals(expected, result);
    }
}