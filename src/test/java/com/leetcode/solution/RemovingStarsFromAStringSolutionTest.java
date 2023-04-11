package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemovingStarsFromAStringSolutionTest {
    private RemovingStarsFromAStringSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RemovingStarsFromAStringSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "leet**cod*e, lecoe",
            "erase*****, "
    })
    void removeStars(String s, String expected) {
        expected = expected == null ? "" : expected;
        String result = solution.removeStars(s);

        assertEquals(expected, result);
    }
}