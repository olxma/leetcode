package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BulbSwitcherSolutionTest {
    private BulbSwitcherSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BulbSwitcherSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 1",
            "4, 2",
            "5, 2",
            "6, 2",
            "7, 2",
            "8, 2",
            "9, 3",
            "10, 3",
            "11, 3",
            "12, 3",
            "15, 3",
            "16, 4",
            "17, 4",
            "18, 4",
            "22, 4",
            "23, 4",
            "24, 4",
            "25, 5",
            "26, 5",
            "27, 5",
            "36, 6",
            "48, 6",
            "49, 7",
            "99999999, 9999"
    })
    void bulbSwitch(int n, int expected) {
        int result = solution.bulbSwitch(n);

        assertEquals(expected, result);
    }
}