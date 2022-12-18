package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Daily Temperatures</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the i<sup>th</sup> day
 * to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.</p>
 *
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">739. Daily Temperatures</a>
 */
public class DailyTemperaturesSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            checkPreviousTemps(temperatures, i, stack, answer);
            stack.push(i);
        }
        return answer;
    }

    private static void checkPreviousTemps(int[] temperatures, int i, Deque<Integer> stack, int[] answer) {
        int t = temperatures[i];
        Integer index;
        while ((index = stack.peek()) != null && t > temperatures[index]) {
            stack.pop();
            answer[index] = i - index;
        }
    }
}
