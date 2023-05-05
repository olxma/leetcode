package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfVowelsInASubstringOfGivenLengthSolutionTest {
    private MaximumNumberOfVowelsInASubstringOfGivenLengthSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumNumberOfVowelsInASubstringOfGivenLengthSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "abciiidef, 3, 3",
            "aeiou, 2, 2",
            "leetcode, 3, 2"
    })
    void maxVowels(String s, int k, int expected) {
        int result = solution.maxVowels(s, k);

        assertEquals(expected, result);
    }
}