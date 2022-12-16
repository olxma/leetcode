package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementQueueUsingStacksSolutionTest {
    private ImplementQueueUsingStacksSolution.MyQueue queue;

    @BeforeEach
    void setUp() {
        queue = new ImplementQueueUsingStacksSolution.MyQueue();
    }

    @Test
    void test() {
        assertTrue(queue.empty());

        queue.push(1);
        assertFalse(queue.empty());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());

        queue.push(2);
        queue.push(3);
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
        assertTrue(queue.empty());
    }
}