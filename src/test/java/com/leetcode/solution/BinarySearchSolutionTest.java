package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchSolutionTest {
    private BinarySearchSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BinarySearchSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,0,3,5,9,12; 9; 4",
            "-1,0,3,5,9,12; 2; -1"
    }, delimiter = ';')
    void search(@ConvertWith(IntegerArrayConverter.class) int[] nums, int target, int expected) {
        int result = solution.search(nums, target);

        assertEquals(expected, result);
    }
}