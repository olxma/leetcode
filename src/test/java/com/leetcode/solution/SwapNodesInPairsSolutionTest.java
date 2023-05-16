package com.leetcode.solution;

import com.leetcode.model.ListNode;
import com.leetcode.util.ListNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwapNodesInPairsSolutionTest {
    private SwapNodesInPairsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SwapNodesInPairsSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4; 2,1,4,3",
            "null;null",
            "1; 1"
    }, delimiter = ';')
    void swapPairs(@ConvertWith(ListNodeConverter.class) ListNode head,
                   @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode result = solution.swapPairs(head);

        assertEquals(expected, result);
    }
}