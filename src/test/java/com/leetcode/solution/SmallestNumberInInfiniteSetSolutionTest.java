package com.leetcode.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestNumberInInfiniteSetSolutionTest {

    @Test
    void test() {
        SmallestNumberInInfiniteSetSolution solution = new SmallestNumberInInfiniteSetSolution();
        solution.addBack(2);
        assertEquals(1, solution.popSmallest());
        assertEquals(2, solution.popSmallest());
        assertEquals(3, solution.popSmallest());
        solution.addBack(1);
        assertEquals(1, solution.popSmallest());
        assertEquals(4, solution.popSmallest());
        assertEquals(5, solution.popSmallest());
    }
}