package com.leetcode.solution;

import java.util.TreeMap;

/**
 * <b>Snapshot Array</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Implement a SnapshotArray that supports the following interface:</p>
 *
 * <ul>
 *     <li>SnapshotArray(int length) initializes an array-like data structure with the given length.
 *     Initially, each element equals 0.</li>
 *     <li>void set(index, val) sets the element at the given index to be equal to val.</li>
 *     <li>int snap() takes a snapshot of the array and returns the snap_id:
 *     the total number of times we called snap() minus 1.</li>
 *     <li>int get(index, snap_id) returns the value at the given index,
 *     at the time we took the snapshot with the given snap_id</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/snapshot-array/">1146. Snapshot Array</a>
 */
public class SnapshotArraySolution {
    private final TreeMap<Integer, Integer>[] array;
    private int snapshotId;

    @SuppressWarnings("unchecked")
    public SnapshotArraySolution(int length) {
        array = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);
            array[i] = map;
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = array[index];
        if (map.lastEntry().getValue() != val) {
            map.put(snapshotId, val);
        }
    }

    public int snap() {
        snapshotId++;
        return snapshotId - 1;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> map = array[index];
        Integer result = map.get(snapId);
        if (result == null) {
            result = map.get(map.lowerKey(snapId));
        }
        return result;
    }
}
