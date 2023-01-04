package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Minimum Rounds to Complete All Tasks</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
 * In each round, you can complete either 2 or 3 tasks of the same difficulty level.</p>
 *
 * <p>Return the minimum rounds required to complete all the tasks,
 * or -1 if it is not possible to complete all the tasks.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">
 * 2244. Minimum Rounds to Complete All Tasks</a>
 */
public class MinimumRoundsToCompleteAllTasksSolution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            int n = map.getOrDefault(task, 0);
            map.put(task, n + 1);
        }
        int rounds = 0;
        for (int n : map.values()) {
            if (n == 1) return -1;
            if (n >= 5 && n % 3 != 0) {
                rounds += 1 + (n / 3);
            } else if (n % 3 == 0) {
                rounds += n / 3;
            } else {
                rounds += n / 2;
            }
        }
        return rounds;
    }
}
