package com.leetcode.solution;

import com.leetcode.model.ListNode;
import com.leetcode.util.ListNodeConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleOfTheLinkedListSolutionTest {
    private static MiddleOfTheLinkedListSolution solution;

    @BeforeAll
    public static void init() {
        solution = new MiddleOfTheLinkedListSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5; 3,4,5",
            "1,2,3,4,5,6; 4,5,6"
    }, delimiter = ';')
    void middleNode(@ConvertWith(ListNodeConverter.class) ListNode input,
                    @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode result = solution.middleNode(input);

        assertEquals(expected, result);
    }
}