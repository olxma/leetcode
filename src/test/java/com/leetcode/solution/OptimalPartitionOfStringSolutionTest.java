package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptimalPartitionOfStringSolutionTest {
    private OptimalPartitionOfStringSolution solution;

    @BeforeEach
    void setUp() {
        solution = new OptimalPartitionOfStringSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "abacaba, 4",
            "ssssss, 6"
    })
    void partitionString(String s, int expected) {
        int result = solution.partitionString(s);

        assertEquals(expected, result);
    }
}