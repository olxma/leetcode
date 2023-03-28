package com.leetcode.solution;

/**
 * <b>Minimum Cost For Tickets</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You have planned some train traveling one year in advance.
 * The days of the year in which you will travel are given as an integer array days.
 * Each day is an integer from 1 to 365.</p>
 *
 * <p>Train tickets are sold in three different ways:</p>
 * <ul>
 *     <li>a 1-day pass is sold for costs[0] dollars,</li>
 *     <li>a 7-day pass is sold for costs[1] dollars, and</li>
 *     <li>a 30-day pass is sold for costs[2] dollars.</li>
 * </ul>
 * <p>The passes allow that many days of consecutive travel.</p>
 *
 * <p>For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.</p>
 * <p>Return the minimum number of dollars you need to travel every day in the given list of days.</p>
 *
 * @see <a href="link">983. Minimum Cost For Tickets</a>
 */
public class MinimumCostForTicketsSolution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + costs[0];
            int j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 1) {
                j--;
            }
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[0]);
            j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 7) {
                j--;
            }
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[1]);
            j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 30) {
                j--;
            }
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[2]);
        }
        return dp[n];
    }

}
