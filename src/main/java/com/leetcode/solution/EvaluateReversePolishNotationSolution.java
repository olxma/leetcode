package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * <b>Climbing Stairs</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Evaluate the value of an arithmetic expression in
 * <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish Notation</a>.</p>
 *
 * <p>Valid operators are +, -, *, and /. Each operand may be an integer or another expression.</p>
 *
 * <p>Note that division between two integers should truncate toward zero.</p>
 *
 * <p>It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result,
 * and there will not be any division by zero operation.</p>
 *
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">150. Evaluate Reverse Polish Notation</a>
 */
@SuppressWarnings("Convert2MethodRef")
public class EvaluateReversePolishNotationSolution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
            "+", (x, y) -> x + y,
            "-", (x, y) -> x - y,
            "*", (x, y) -> x * y,
            "/", (x, y) -> x / y);

    public int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();
        for (String token : tokens) {
            var operation = OPERATIONS.get(token);
            if (operation != null) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(operation.apply(x, y));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
