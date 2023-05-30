package com.leetcode.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DesignHashSetSolutionTest {

    @Test
    void test() {
        DesignHashSetSolution solution = new DesignHashSetSolution();
        solution.add(1);
        solution.add(2);
        assertTrue(solution.contains(1));
        assertFalse(solution.contains(3));
        solution.add(2);
        assertTrue(solution.contains(2));
        solution.remove(2);
        assertFalse(solution.contains(2));
    }

}