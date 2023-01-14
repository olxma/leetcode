package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicallySmallestEquivalentStringSolutionTest {
    private LexicographicallySmallestEquivalentStringSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LexicographicallySmallestEquivalentStringSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "parker;    morris;     parser;     makkek",
            "hello;     world;      hold;       hdld",
            "leetcode;  programs;   sourcecode; aauaaaaada"
    }, delimiter = ';')
    void smallestEquivalentString(String s1, String s2, String baseStr, String expected) {
        String result = solution.smallestEquivalentString(s1, s2, baseStr);

        assertEquals(expected, result);
    }
}