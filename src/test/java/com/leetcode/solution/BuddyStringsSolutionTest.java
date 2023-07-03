package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuddyStringsSolutionTest {
    private BuddyStringsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BuddyStringsSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "ab, ba, true",
            "ab, ab, false",
            "aa, aa, true"
    })
    void buddyStrings(String s, String goal, boolean expected) {
        boolean result = solution.buddyStrings(s, goal);

        assertEquals(expected, result);
    }
}