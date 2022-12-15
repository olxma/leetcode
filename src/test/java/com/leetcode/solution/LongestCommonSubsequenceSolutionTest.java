package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceSolutionTest {
    private LongestCommonSubsequenceSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LongestCommonSubsequenceSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "abcde, ace, 3",
            "abc, abc, 3",
            "abc, def, 0",
            "oxcpqrsvwf, shmtulqrypy, 2",
            "abcba, abcbcba, 5",
            "pmjghexybyrgzczy, hafcdqbgncrcbihkd, 4"
    })
    void longestCommonSubsequence(String text1, String text2, int expected) {
        int result = solution.longestCommonSubsequence(text1, text2);

        assertEquals(expected, result);
    }
}