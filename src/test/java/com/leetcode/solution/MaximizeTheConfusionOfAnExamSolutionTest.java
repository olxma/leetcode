package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizeTheConfusionOfAnExamSolutionTest {
    private MaximizeTheConfusionOfAnExamSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximizeTheConfusionOfAnExamSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "TTFF, 2, 4",
            "TFFT, 1, 3",
            "TTFTTFTT, 1, 5"
    })
    void maxConsecutiveAnswers(String answerKey, int k, int expected) {
        int result = solution.maxConsecutiveAnswers(answerKey, k);

        assertEquals(expected, result);
    }
}