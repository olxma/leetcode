package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplifyPathSolutionTest {
    private SimplifyPathSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SimplifyPathSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "/home/, /home",
            "/../, /",
            "/home//foo/, /home/foo",
            "/home///foo/, /home/foo",
            "/a/./b/../../c/, /c"
    })
    void simplifyPath(String path, String expected) {
        String result = solution.simplifyPath(path);

        assertEquals(expected, result);
    }
}