package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Valid Parentheses</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.</p>
 * <p>An input string is valid if:</p>
 * <ul>
 *     <li>Open brackets must be closed by the same type of brackets.</li>
 *     <li>Open brackets must be closed in the correct order.</li>
 *     <li>Every close bracket has a corresponding open bracket of the same type.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/description/">
 * 20. Valid Parentheses</a>
 */
public class ValidParenthesesSolution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenParenthesis(c)) {
                stack.addFirst(c);
            } else if (isCloseParenthesis(c) && hasNoPair(stack, c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpenParenthesis(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isCloseParenthesis(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private static boolean hasNoPair(Deque<Character> stack, char c) {
        return stack.isEmpty() || !isPair(stack.removeFirst(), c);
    }

    private static boolean isPair(Character x, Character y) {
        return switch (x) {
            case '{' -> y == '}';
            case '[' -> y == ']';
            case '(' -> y == ')';
            default -> false;
        };
    }
}
