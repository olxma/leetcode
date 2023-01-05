package com.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <b>Minimum Number of Arrows to Burst Balloons</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where
 * points[i] = [x<sub>start</sub>, x<sub>end</sub>] denotes a balloon whose horizontal diameter stretches
 * between x<sub>start</sub> and x<sub>end</sub>. You do not know the exact y-coordinates of the balloons.</p>
 *
 * <p>Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with x<sub>start</sub> and x<sub>end</sub> is burst by an arrow shot at x
 * if x<sub>start</sub> <= x <= x<sub>end</sub>. There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.</p>
 *
 * <p>Given the array points, return the minimum number of arrows that must be shot to burst all balloons.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">
 * 452. Minimum Number of Arrows to Burst Balloons</a>
 */
public class MinimumNumberOfArrowsToBurstBalloonsSolution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int arrows = 1;
        int min = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            if (start > min) {
                arrows++;
                min = end;
            } else {
                min = Math.min(min, end);
            }
        }
        return arrows;
    }
}
