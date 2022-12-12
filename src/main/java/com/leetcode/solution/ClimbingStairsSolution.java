package com.leetcode.solution;

/**
 * <b>Climbing Stairs</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are climbing a staircase. It takes n steps to reach the top.</p>
 *
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?</p>
 *
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 */
public class ClimbingStairsSolution {
    public int climbStairs(int n) {
        int[] ways = new int[n];
        if (ways.length > 0) {
            ways[0] = 1;
        }
        if (ways.length > 1) {
            ways[1] = 2;
        }
        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }
        return ways[n - 1];
    }
}
