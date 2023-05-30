package com.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Design HashSet</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Design a HashSet without using any built-in hash table libraries.</p>
 *
 * <p>Implement MyHashSet class:</p>
 * <ul>
 *     <li>void add(key) Inserts the value key into the HashSet.</li>
 *     <li>bool contains(key) Returns whether the value key exists in the HashSet or not.</li>
 *     <li>void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/design-hashset/description/">705. Design HashSet</a>
 */
public class DesignHashSetSolution {
    private final List<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public DesignHashSetSolution() {
        buckets = new List[16];
    }

    public void add(int key) {
        List<Integer> bucket = getBucket(key);
        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[getIndex(key)] = bucket;
        }
        boolean exists = false;
        for (Integer b : bucket) {
            if (b == key) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        List<Integer> bucket = getBucket(key);
        if (bucket != null) {
            bucket.removeIf(b -> b == key);
        }
    }

    public boolean contains(int key) {
        List<Integer> bucket = getBucket(key);
        return bucket != null && bucket.contains(key);
    }

    private int getIndex(int key) {
        int hashCode = Integer.hashCode(key);
        return hashCode % buckets.length;
    }

    private List<Integer> getBucket(int key) {
        return buckets[getIndex(key)];
    }
}
