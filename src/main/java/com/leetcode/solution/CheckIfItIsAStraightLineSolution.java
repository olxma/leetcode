package com.leetcode.solution;

/**
 * <b>Check If It Is a Straight Line</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.</p>
 *
 * @see <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">
 * 1232. Check If It Is a Straight Line</a>
 */
public class CheckIfItIsAStraightLineSolution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;

        int dxBase = coordinates[0][0] - coordinates[1][0];
        int dyBase = coordinates[0][1] - coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            int dxCurrent = coordinates[0][0] - coordinates[i][0];
            int dyCurrent = coordinates[0][1] - coordinates[i][1];
            if (dxCurrent * dyBase != dyCurrent * dxBase) return false;
        }
        return true;
    }
}
