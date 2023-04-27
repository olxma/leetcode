package com.leetcode.solution;

/**
 * <b>Bulb Switcher</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are n bulbs that are initially off. You first turn on all the bulbs,
 * then you turn off every second bulb.</p>
 *
 * <p>On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the i<sup>th</sup> round, you toggle every i bulb.
 * For the n<sup>th</sup> round, you only toggle the last bulb.</p>
 *
 * <p>Return the number of bulbs that are on after n rounds.</p>
 *
 * @see <a href="https://leetcode.com/problems/bulb-switcher/">319. Bulb Switcher</a>
 */
public class BulbSwitcherSolution {
    public int bulbSwitch(int n) {
        for (int i = 1; i <= n; i++) {
            if (i * i == n) {
                return i;
            }
            if (i * i > n) {
                return i - 1;
            }
        }
        return 0;
    }
}
