package com.leetcode.solution;

import com.leetcode.model.ListNode;
import com.leetcode.util.ListNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumTwinSumOfALinkedListSolutionTest {
    private MaximumTwinSumOfALinkedListSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumTwinSumOfALinkedListSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,4,2,1; 6",
            "4,2,2,3; 7",
            "1,100000; 100001"
    }, delimiter = ';')
    void pairSum(@ConvertWith(ListNodeConverter.class) ListNode head, int expected) {
        int result = solution.pairSum(head);

        assertEquals(expected, result);
    }
}