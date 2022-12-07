package com.leetcode.solution;

import com.leetcode.model.ListNode;
import com.leetcode.util.ListNodeConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddEvenLinkedListSolutionTest {
    private static OddEvenLinkedListSolution solution;

    @BeforeAll
    public static void init() {
        solution = new OddEvenLinkedListSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3; 1,3,2",
            "1,2,3,4,5; 1,3,5,2,4",
            "2,1,3,5,6,4,7; 2,3,6,7,1,5,4"
    }, delimiter = ';')
    void oddEvenList(@ConvertWith(ListNodeConverter.class) ListNode input,
                     @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode result = solution.oddEvenList(input);

        assertEquals(expected, result);
    }
}