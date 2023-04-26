package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddDigitsSolutionTest {
    private AddDigitsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new AddDigitsSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "38, 2",
    })
    void addDigits(int num, int expected) {
        int result = solution.addDigits(num);

        assertEquals(expected, result);
    }
}