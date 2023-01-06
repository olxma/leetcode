package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>Maximum Ice Cream Bars</b>
 * <p>Level: <i>Medium</i></p>
 * <p>It is a sweltering summer day, and a boy wants to buy some ice cream bars.</p>
 * <p>At the store, there are n ice cream bars. You are given an array costs of length n,
 * where costs[i] is the price of the ith ice cream bar in coins.
 * The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. </p>
 *
 * <p>Return the maximum number of ice cream bars the boy can buy with coins coins.</p>
 *
 * <p>Note: The boy can buy the ice cream bars in any order.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-ice-cream-bars/">1833. Maximum Ice Cream Bars</a>
 */
public class MaximumIceCreamBarsSolution {
    // #1 Approach
    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                bars++;
                coins -= cost;
            }
        }
        return bars;
    }

    // #2 Approach
    public int maxIceCream2(int[] costs, int coins) {
        int bars = 0;
        int max = Integer.MIN_VALUE;
        for (int cost : costs) {
            max = Math.max(max, cost);
        }

        int[] costsFrequency = new int[max + 1];
        for (int cost : costs) {
            costsFrequency[cost]++;
        }

        for (int cost = 1; cost <= max; ++cost) {
            if (costsFrequency[cost] == 0) {
                continue;
            }
            if (coins < cost) {
                break;
            }
            int count = Math.min(costsFrequency[cost], coins / cost);
            coins -= cost * count;
            bars += count;
        }
        return bars;
    }
}
