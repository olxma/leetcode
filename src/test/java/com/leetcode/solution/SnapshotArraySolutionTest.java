package com.leetcode.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnapshotArraySolutionTest {

    @Test
    void test_base() {
        SnapshotArraySolution solution = new SnapshotArraySolution(3);
        solution.set(0, 5);
        assertEquals(0, solution.snap());
        solution.set(0, 6);
        assertEquals(5, solution.get(0, 0));
    }

    @Test
    void test_case42() {
        SnapshotArraySolution solution = new SnapshotArraySolution(3);
        solution.set(1, 6);
        assertEquals(0, solution.snap());
        assertEquals(1, solution.snap());
        solution.set(1, 19);
        solution.set(0, 4);
        assertEquals(0, solution.get(2, 1));
        assertEquals(0, solution.get(2, 0));
        assertEquals(0, solution.get(0, 1));
    }

    @Test
    void test_case44() {
        SnapshotArraySolution solution = new SnapshotArraySolution(1);
        solution.set(0, 15);
        solution.snap();
        solution.snap();
        solution.snap();
        assertEquals(15, solution.get(0, 2));
        solution.snap();
        solution.snap();
        assertEquals(15, solution.get(0, 0));
    }
}