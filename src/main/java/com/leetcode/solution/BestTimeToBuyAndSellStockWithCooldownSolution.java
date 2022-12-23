package com.leetcode.solution;

/**
 * <b>Best Time to Buy and Sell Stock with Cooldown</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You are given an array prices where prices[i] is the price of a given stock on the i<sup>th</sup> day.</p>
 *
 * <p>Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:</p>
 *
 * <ul>
 *     <li>After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).</li>
 * </ul>
 *
 * <p>Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).</p>
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">
 * 309. Best Time to Buy and Sell Stock with Cooldown</a>
 */
public class BestTimeToBuyAndSellStockWithCooldownSolution {
    public int maxProfit(int[] prices) {
        int profit1 = 0; //max profit on day i if we sell
        int profit2 = 0; //max profit on day i if we do nothing

        for (int i = 1; i < prices.length; i++) {
            int prevProfit1 = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
            profit2 = Math.max(prevProfit1, profit2);
        }

        return Math.max(profit1, profit2);
    }
}