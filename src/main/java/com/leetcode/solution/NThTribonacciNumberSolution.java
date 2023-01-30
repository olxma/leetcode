package com.leetcode.solution;

/**
 * <b>N-th Tribonacci Number</b>
 * <p>Level: <i>Easy</i></p>
 * <p>The Tribonacci sequence T<sub>n</sub> is defined as follows: </p>
 *
 * <p>T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1,
 * and T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub> for n >= 0.</p>
 *
 * <p>Given n, return the value of T<sub>n</sub>.</p>
 *
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number/">1137. N-th Tribonacci Number</a>
 */
public class NThTribonacciNumberSolution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 3] + res[i- 2] + res[i -1];
        }
        return res[n];
    }
}
