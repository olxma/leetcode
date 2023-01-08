package com.leetcode.solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Max Points on a Line</b>
 * <p>Level: <i>Hard</i></p>
 * <p>Given an array of points where points[i] = [x<sub>i</sub>, y<sub>i</sub>] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.</p>
 *
 * @see <a href="https://leetcode.com/problems/max-points-on-a-line/">149. Max Points on a Line</a>
 */
public class MaxPointsOnALineSolution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> angles = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    angles.merge(atan2(points[i], points[j]), 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(angles.values()) + 1);
        }
        return result;
    }

    private static double atan2(int[] point1, int[] point2) {
        return Math.atan2(point2[1] - point1[1], point2[0] - point1[0]);
    }
}
