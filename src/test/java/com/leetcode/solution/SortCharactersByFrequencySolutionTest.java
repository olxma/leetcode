package com.leetcode.solution;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortCharactersByFrequencySolutionTest {
    private static SortCharactersByFrequencySolution solution;

    @BeforeAll
    public static void init() {
        solution = new SortCharactersByFrequencySolution();
    }

    @ParameterizedTest
    @CsvSource({
            "tree,eert",
            "cccaaa,aaaccc",
            "Aabb,bbaA"
    })
    void frequencySort(String input, String expectedResult) {
        String result = solution.frequencySort(input);
        assertEquals(expectedResult, result);
    }
}