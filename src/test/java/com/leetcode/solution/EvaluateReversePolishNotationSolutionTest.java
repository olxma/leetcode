package com.leetcode.solution;

import com.leetcode.util.StringArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateReversePolishNotationSolutionTest {
    private EvaluateReversePolishNotationSolution solution;

    @BeforeEach
    void setUp() {
        solution = new EvaluateReversePolishNotationSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,1,+,3,*; 9",
            "4,13,5,/,+; 6",
            "10,6,9,3,+,-11,*,/,*,17,+,5,+; 22"
    }, delimiter = ';')
    void evalRPN(@ConvertWith(StringArrayConverter.class) String[] tokens, int expected) {
        int result = solution.evalRPN(tokens);

        assertEquals(expected, result);
    }
}