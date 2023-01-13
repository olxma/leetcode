package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPathWithDifferentAdjacentCharactersSolutionTest {
    private static LongestPathWithDifferentAdjacentCharactersSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LongestPathWithDifferentAdjacentCharactersSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,0,0,1,1,2;  abacbe; 3",
            "-1,0,0,0;      aabc;   3",
            "-1,0,1;        aab;    2",
            "-1,0,1,2,3,4;  zzabab; 5"
    }, delimiter = ';')
    void longestPath(@ConvertWith(IntegerArrayConverter.class) int[] parent, String s, int expected) {
        int result = solution.longestPath(parent, s);

        assertEquals(expected, result);
    }
}