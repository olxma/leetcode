package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordPatternSolutionTest {
    private WordPatternSolution solution;

    @BeforeEach
    void setUp() {
        solution = new WordPatternSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "abba, dog cat cat dog, true",
            "abba, dog cat cat fish, false",
            "aaaa, dog cat cat dog, false",
            "abba, dog dog dog dog, false"
    })
    void wordPattern(String pattern, String s, boolean expected) {
        boolean result = solution.wordPattern(pattern, s);

        assertEquals(expected, result);
    }
}