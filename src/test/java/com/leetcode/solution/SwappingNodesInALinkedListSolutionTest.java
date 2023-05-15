package com.leetcode.solution;

import com.leetcode.model.ListNode;
import com.leetcode.util.ListNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwappingNodesInALinkedListSolutionTest {
    private SwappingNodesInALinkedListSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SwappingNodesInALinkedListSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5; 2; 1,4,3,2,5",
            "7,9,6,6,7,8,3,0,9,5; 5; 7,9,6,6,8,7,3,0,9,5",
            "1; 1; 1",
            "1,2; 1; 2,1",
            "80,46,66,35,64; 1; 64,46,66,35,80",
            "100,90; 2; 90,100"
    }, delimiter = ';')
    void swapNodes(@ConvertWith(ListNodeConverter.class) ListNode head, int k,
                   @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode result = solution.swapNodes(head, k);
        assertEquals(expected, result);
    }
}