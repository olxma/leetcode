package com.leetcode.solution;

import com.leetcode.model.ListNode;
import com.leetcode.util.ListNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersIISolutionTest {
    private AddTwoNumbersIISolution solution;

    @BeforeEach
    void setUp() {
        solution = new AddTwoNumbersIISolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "7,2,4,3; 5,6,4; 7,8,0,7",
            "2,4,3; 5,6,4; 8,0,7",
            "0; 0; 0"
    }, delimiter = ';')
    void addTwoNumbers(@ConvertWith(ListNodeConverter.class) ListNode l1,
                       @ConvertWith(ListNodeConverter.class) ListNode l2,
                       @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }
}