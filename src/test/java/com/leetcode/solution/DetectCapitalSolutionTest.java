package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetectCapitalSolutionTest {
    private DetectCapitalSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DetectCapitalSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "USA, true",
            "FlaG, false",
            "Leetcode, true"
    })
    void detectCapitalUse(String word, boolean expected) {
        boolean result = solution.detectCapitalUse(word);

        assertEquals(expected, result);
    }
}