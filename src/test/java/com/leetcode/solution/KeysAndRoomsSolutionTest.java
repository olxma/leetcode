package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KeysAndRoomsSolutionTest {
    private KeysAndRoomsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new KeysAndRoomsSolution();
    }

    @Test
    void canVisitAllRooms() {
        List<List<Integer>> rooms1 = List.of(List.of(1), List.of(2), List.of(3), List.of());
        assertTrue(solution.canVisitAllRooms(rooms1));

        List<List<Integer>> rooms2 = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        assertFalse(solution.canVisitAllRooms(rooms2));
    }
}