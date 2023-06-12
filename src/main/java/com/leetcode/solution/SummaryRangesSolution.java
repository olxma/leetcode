package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Summary Ranges</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are given a sorted unique integer array nums.</p>
 *
 * <p>A range [a,b] is the set of all integers from a to b (inclusive).</p>
 *
 * <p>Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges,
 * and there is no integer x such that x is in one of the ranges but not in nums.</p>
 *
 * <p>Each range [a,b] in the list should be output as:</p>
 * <ul>
 *     <li>"a->b" if a != b</li>
 *     <li>"a" if a == b</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/summary-ranges/">228. Summary Ranges</a>
 */
public class SummaryRangesSolution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }

        int start = 0;
        int prev = start;
        int index = 1;
        while (index < nums.length) {
            if (Math.abs(nums[index] - nums[prev]) > 1) {
                ranges.add(getRangeAsString(nums[start], nums[prev]));
                start = index;
            }
            prev = index;
            index++;
        }
        ranges.add(getRangeAsString(nums[start], nums[prev]));
        return ranges;
    }

    private static String getRangeAsString(int startNum, int endNum) {
        String result;
        if (startNum != endNum) {
            result = String.format("%d->%d", startNum, endNum);
        } else {
            result = Integer.toString(startNum);
        }
        return result;
    }
}
