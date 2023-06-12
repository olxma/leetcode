package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import com.leetcode.util.StringListConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummaryRangesSolutionTest {
    private SummaryRangesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SummaryRangesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,1,2,4,5,7; 0->2, 4->5, 7",
            "0,2,3,4,6,8,9; 0, 2->4, 6, 8->9",
            "-2147483648,-2147483647,2147483647; -2147483648->-2147483647, 2147483647"
    }, delimiter = ';')
    void summaryRanges(@ConvertWith(IntegerArrayConverter.class) int[] nums,
                       @ConvertWith(StringListConverter.class) List<String> expected) {
        List<String> result = solution.summaryRanges(nums);

        assertEquals(expected, result);
    }
}