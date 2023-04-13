package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Validate Stack Sequences</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given two integer arrays pushed and popped each with distinct values,
 * return true if this could have been the result of a sequence of push and pop operations on an initially empty stack,
 * or false otherwise.</p>
 *
 * @see <a href="https://leetcode.com/problems/validate-stack-sequences/">946. Validate Stack Sequences</a>
 */
public class ValidateStackSequencesSolution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(pushed[0]);
        int j = 1;
        for (int i = 0; i < popped.length; i++) {
            int x = popped[i];
            while (j < pushed.length && (stack.isEmpty() || stack.peek() != x)) {
                stack.push(pushed[j++]);
            }
            if ((stack.isEmpty() && i < popped.length - 1) || (!stack.isEmpty() && stack.pop() != x)) {
                return false;
            }
        }
        return true;
    }
}
