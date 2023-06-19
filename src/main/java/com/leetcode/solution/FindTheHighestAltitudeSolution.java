package com.leetcode.solution;

/**
 * <b>Find the Highest Altitude</b>
 * <p>Level: <i>Easy</i></p>
 * <p>There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
 * The biker starts his trip on point 0 with altitude equal 0.</p>
 *
 * <p>You are given an integer array gain of length n where gain[i] is the net gain in altitude
 * between points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-the-highest-altitude/">1732. Find the Highest Altitude</a>
 */
public class FindTheHighestAltitudeSolution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int altitude = 0;
        for (int expected : gain) {
            altitude += expected;
            highestAltitude = Math.max(highestAltitude, altitude);
        }
        return highestAltitude;
    }
}
