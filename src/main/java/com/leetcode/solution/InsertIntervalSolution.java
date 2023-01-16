package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Insert Interval</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given an array of non-overlapping intervals intervals
 * where intervals[i] = [start<sub>i</sub>, end<sub>i</sub>] represent
 * the start and the end of the i<sup>th</sup> interval and intervals is sorted
 * in ascending order by start<sub>i</sub>.
 * You are also given an interval newInterval = [start, end]
 * that represents the start and end of another interval.</p>
 *
 * <p>Insert newInterval into intervals such that intervals is still sorted in ascending order
 * by start<sub>i</sub> and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).</p>
 *
 * <p>Return intervals after the insertion.</p>
 *
 * @see <a href="https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>
 */
public class InsertIntervalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        boolean isInserted = false;

        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1]) {
                if (!isInserted) {
                    merged.add(newInterval);
                    isInserted = true;
                }
                merged.add(interval);
            } else {
                if (isOverlap(newInterval, interval)) {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }
        }
        if (!isInserted) {
            merged.add(newInterval);
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    private static boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[0] <= interval2[1] && interval2[0] <= interval1[1];
    }
}
