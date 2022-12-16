package com.leetcode.solution;

import java.util.Stack;

/**
 * <b>Implement Queue using Stacks</b>
 * <p>Level: <i>Easy</i></p>
 *
 * <p>Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).</p>
 *
 * <p>Implement the MyQueue class:</p>
 *
 * <ul>
 *     <li>void push(int x) Pushes element x to the back of the queue.</li>
 *     <li>int pop() Removes the element from the front of the queue and returns it.</li>
 *     <li>int peek() Returns the element at the front of the queue.</li>
 *     <li>boolean empty() Returns true if the queue is empty, false otherwise.</li>
 * </ul>
 *
 * <p>Notes:</p>
 *
 * <ul>
 *  <li>You must use only standard operations of a stack,
 *  which means only push to top, peek/pop from top, size, and is empty operations are valid.</li>
 *
 *  <li>Depending on your language, the stack may not be supported natively.
 *  You may simulate a stack using a list or deque (double-ended queue)
 *  as long as you use only a stack's standard operations.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/">232. Implement Queue using Stacks</a>
 */
public class ImplementQueueUsingStacksSolution {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    static class MyQueue {
        private final Stack<Integer> s1;
        private final Stack<Integer> s2;
        private int front;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            if (s1.empty()) {
                front = x;
            }
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }
            return front;
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
