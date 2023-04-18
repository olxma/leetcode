package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeStringsAlternatelySolutionTest {
    private MergeStringsAlternatelySolution solution;

    @BeforeEach
    void setUp() {
        solution = new MergeStringsAlternatelySolution();
    }

    @ParameterizedTest
    @CsvSource({
            "abc, pqr, apbqcr",
            "ab, pqrs, apbqrs",
            "abcd, pq, apbqcd"
    })
    void mergeAlternately(String word1, String word2, String expected) {
        String result = solution.mergeAlternately(word1, word2);

        assertEquals(expected, result);
    }
}