package com.leetcode.solution;

/**
 * <b>Gas Station</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are n gas stations along a circular route,
 * where the amount of gas at the i<sup>th</sup> station is gas[i].</p>
 *
 * <p>You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the i<sup>th</sup> station
 * to its next (i + 1)<sup>th</sup> station. You begin the journey with an empty tank at one of the gas stations.</p>
 *
 * <p>Given two integer arrays gas and cost, return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique.</p>
 *
 * @see <a href="https://leetcode.com/problems/gas-station/">134. Gas Station</a>
 */
public class GasStationSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalDiff = 0;
        int currDiff = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;
            currDiff += diff;
            if (currDiff < 0) {
                index = i + 1;
                currDiff = 0;
            }
        }
        return totalDiff < 0 ? -1 : index;
    }
}
