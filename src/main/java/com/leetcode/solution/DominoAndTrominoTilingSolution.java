package com.leetcode.solution;

/**
 * <b>Domino and Tromino Tiling</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You have two types of tiles:
 * <a href="https://assets.leetcode.com/uploads/2021/07/15/lc-domino.jpg">
 * a 2 x 1 domino shape and a tromino shape</a>.
 * You may rotate these shapes.</p>
 *
 * <p>Given an integer n, return the number of ways to tile an 2 x n board.
 * Since the answer may be very large, return it modulo 10<sup>9</sup> + 7.</p>
 *
 * <p>In a tiling, every square must be covered by a tile.
 * Two tilings are different if and only if there are two 4-directionally adjacent cells on the board
 * such that exactly one of the tilings has both squares occupied by a tile.</p>
 *
 * @see <a href="https://leetcode.com/problems/domino-and-tromino-tiling/">790. Domino and Tromino Tiling</a>
 */
public class DominoAndTrominoTilingSolution {
    private static final int MOD = (int) Math.pow(10, 9) + 7;

    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 1] * 2) % MOD + dp[i - 3];
        }
        return (int) (dp[n - 1] % MOD);
    }
}
