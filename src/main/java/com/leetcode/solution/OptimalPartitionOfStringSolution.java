package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>Optimal Partition of String</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a string s, partition the string into one or more substrings such
 * that the characters in each substring are unique.
 * That is, no letter appears in a single substring more than once.</p>
 *
 * <p>Return the minimum number of substrings in such a partition.</p>
 *
 * <p>Note that each character should belong to exactly one substring in a partition.</p>
 *
 * @see <a href="https://leetcode.com/problems/optimal-partition-of-string/description/">2405. Optimal Partition of String</a>
 */
public class OptimalPartitionOfStringSolution {
    public int partitionString(String s) {
        return getPartitions(0, s, new HashSet<>(), 1);
    }

    private static int getPartitions(int i, String s, Set<Character> set, int res) {
        if (i >= s.length()) return res;
        char c = s.charAt(i);
        if (!set.contains(c)) {
            set.add(c);
            return getPartitions(i + 1, s, set, res);
        }
        return getPartitions(i, s, new HashSet<>(), res + 1);
    }
}
