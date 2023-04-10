package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesesSolutionTest {
    private ValidParenthesesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ValidParenthesesSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "(), true",
            "()[]{}, true",
            "(], false"
    })
    void isValid(String s, boolean expected) {
        boolean result = solution.isValid(s);

        assertEquals(expected, result);
    }
}